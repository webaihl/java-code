package org.example.code;

/**
 * @author web
 * @date 2022年07月28日
 *  * [168] Excel表列名称
 */
public class ExcelColumn {

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(2147483647));
        System.out.println("--------------------------------------------");
        System.out.println(convertToNum2(convertToTitle(52)));
        System.out.println(convertToNum2(convertToTitle(1)));
        System.out.println(convertToNum2(convertToTitle(28)));
        System.out.println(convertToNum2(convertToTitle(2147483647)));
    }

    public static String num2Char(int number) {
        if (number > -1 && number < 26){
            return String.valueOf((char) (65+number));
        }
        return "";
    }

    public static String convertToTitle(int columnNumber){
        StringBuilder a = new StringBuilder();
        char b;
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                b = 'Z';
                columnNumber = columnNumber / 26 - 1;
            } else {
                b = (char) (columnNumber % 26 + 64);
                columnNumber = columnNumber / 26;
            }
            a.append(b);
        }
        return a.reverse().toString();
    }
    public static int convertToNum(String columnTitle){
        char[] chars = columnTitle.toCharArray();
        int sum = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            if (chars[i] == 'Z' && i != 0){
                sum += ((chars[i-1] - 64 + 1) * Math.pow(26,chars.length - i));
                i--;
                continue;
            }
            sum += (chars[i] - 64) * Math.pow(26,chars.length - i - 1);
        }
        return sum;
    }

    public static int convertToNum2(String columnTitle){

        int sum = 0;
        for (int i=0;i<columnTitle.length();i++) {
           int num = columnTitle.charAt(i) - 'A' + 1;
           //越往后*8越多，
           sum = sum*26 + num;
        }
        return sum;
    }
}
