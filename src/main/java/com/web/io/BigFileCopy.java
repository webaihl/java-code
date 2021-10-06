package com.web.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

//大文件拷贝
public class BigFileCopy {

    public static void copy(String sourcePath, String targetPath) throws IOException {
        try (FileChannel inputChannel = new FileInputStream(sourcePath).getChannel();
             FileChannel outputChannel = new FileOutputStream(targetPath).getChannel()) {

            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }
    }
    
}
