package org.example.code.binarySearch;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FirstBadVersion.java
 * @Description 278   n 个版本 [1, 2, ..., n]
 * @createTime 2022年09月20日 21:24:00
 */
public class FirstBadVersion278 {

    boolean isBadVersion(int version){
//        return version >= 1702766719;
        return version >= 2147483647;
    }

    public int firstBadVersion(int n) {
        int l = 0,r = n,m;//此除n+1可能会溢出，不过因为肯定存在错误版本，所以可以默认是最后一个，即直接为红色
        while (l != r - 1){
            m = l + (r-l)/2;
            if (!isBadVersion(m)){
                l = m;
            }else {
                r = m;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        FirstBadVersion278 a = new FirstBadVersion278();
        System.out.println(a.firstBadVersion(2126753390));
        System.out.println(a.firstBadVersion(2147483647));
    }
}
