package org.example.code;

/**
 * @author web
 * @date 2022年08月22日
 */
public class PalindromeStr680 {


    public static void main(String[] args) {
        System.out.println(new PalindromeStr680().validPalindrome("abca"));
        System.out.println(new PalindromeStr680().validPalindrome("acba"));
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j){
            if (chars[i++] != chars[j--]){
                return isPalindrome(chars,i+1,j) || isPalindrome(chars,i,j-1);
            }
        }

        return true;
    }

    private boolean isPalindrome(char[] chars, int i,int j){
        while (i<=j){
            if (chars[i++] != chars[j--]){
                return false;
            }
        }
        return true;
    }

}
