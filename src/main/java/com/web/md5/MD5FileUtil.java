package com.web.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(MD5FileUtil.class);
    /**
     * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校 * 验下载的文件的正确性用的就是默认的这个组合
     */
    private static char[] hexDigits =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5FileUtil messagedigest初始化失败", e);
        }
    }

    /**
     * 生成文件的md5校验值 * @param file 文件路径 * @return MD5码返回 * @throws IOException
     */
    public static String getFileMD5(File file) throws IOException {
        String encrStr ;
        // 读取文件
        FileInputStream fis = new FileInputStream(file);
        // 当文件<2G可以直接读取
        if (file.length() <= Integer.MAX_VALUE) {
            encrStr = getMD5Lt2G(file, fis);
        } else {
            // 当文件>2G需要切割读取
            encrStr = getMD5Gt2G(fis);
        }
        fis.close();
        return encrStr;
    }

    /**
     * 小于2G文件
     * * @param fis 文件输入流
     * * @return * @throws IOException
     */
    public static String getMD5Lt2G(File file, FileInputStream fis) throws IOException {
        // 加密码
        String encrStr;
        FileChannel ch = fis.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        messagedigest.update(byteBuffer);
        encrStr = bufferToHex(messagedigest.digest());
        return encrStr;
    }

    /**
     * 超过2G文件的md5算法
     * * @param fileName
     * * @param InputStream
     * * @return
     * * @throws Exception
     */
    public static String getMD5Gt2G(InputStream fis) throws IOException {
        // 自定义文件块读写大小，一般为4M，对于小文件多的情况可以降低
        byte[] buffer = new byte[1024 * 1024 * 4];
        int numRead;
        while ((numRead = fis.read(buffer)) > 0) {
            messagedigest.update(buffer, 0, numRead);
        }
        return bufferToHex(messagedigest.digest());
    }

    /**
     * * @param bt 文件字节流 * @param stringbuffer 文件缓存
     */
    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        // 取字节中低 4 位的数字转换
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    /**
     * 判断字符串的md5校验码是否与一个已知的md5码相匹配 * * @param password 要校验的字符串 * @param md5PwdStr 已知的md5校验码 * @return
     */
    public static boolean checkPassword(String password, String md5PwdStr) {
        String s = getMD5String(password);
        return s.equals(md5PwdStr);
    }

    /**
     * 生成字符串的md5校验值 * * @param s * @return
     */
    public static String getMD5String(String s) {
        return getMD5String(s.getBytes());
    }

    /**
     * 生成字节流的md5校验值 * * @param s * @return
     */
    public static String getMD5String(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }

    public static void main(String[] args) throws IOException {
        String pahUrl = "/home/web/Videos/jszb.mp4";
        long begin = System.currentTimeMillis();
        File big = new File(pahUrl);
        String md5 = getFileMD5(big);
        long end = System.currentTimeMillis();
        System.out.println("md5:" + md5);
        System.out.println("time:" + ((end - begin) / 1000) + "s");
    }
}