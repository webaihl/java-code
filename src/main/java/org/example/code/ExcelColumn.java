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
}
