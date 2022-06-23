package org.example.code;

/**
 * @author web
 * @date 2022年06月21日
 * 两端向中间。 中间向两端需要考虑奇偶问题
 */

public class EvertStr {

    public static void main(String[] args) {
        System.out.println(new EvertStr().evert("0"));
        System.out.println(new EvertStr().evert("1234567"));
        System.out.println(new EvertStr().evert("7654321"));
        System.out.println(new EvertStr().evert("世界"));
        System.out.println(new EvertStr().evert("100"));
    }

    public String evert(String n){
       char[] chars = n.toCharArray();
       int i = 0,j=chars.length-1;
       char tmp;
       while (i<j){
           tmp = chars[i];
           chars[i]=chars[j];
           chars[j]=tmp;
           i++;
           j--;
       }
       return String.valueOf(chars);
    }
}
