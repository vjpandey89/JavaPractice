package com.test;
import java.lang.StringBuilder;

public class Problem_4_Largest_Palindrome_Product {

    /* A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.
       Find the largest palindrome made from the product of two 3-digit numbers. */
    public static void main(String[] args) {
        System.out.println(findLargestPalindrome());
    }
    
    /* determines whether or not an integer is a palindrome;
       that is, if it reads the same from both ways */
    public static boolean isPalindrome(long n) {
        String s = String.valueOf(n);
        StringBuilder reverseString = new StringBuilder();
        
        // reverse the string
        for (int i = s.length() - 1; i > -1; i--) {
            reverseString.append(s.charAt(i));
        }

        return reverseString.toString().equals(s);
    }
        
    /* using the reverse() method in the StringBuilder class
       instead of reversing the string through iterations */
    public static boolean isPalindrome2(long n) {
        String s = String.valueOf(n);  
        return new StringBuilder(s).reverse().toString().equals(s);
    }
    
    /* returns largest palindrome that is a multiple of two 3 digit numbers
       and returns -1 if no such palindrome exists */
    public static long findLargestPalindrome() {
        long palindrome = -1;
        
        for (int i = 999; i > 99; i--) {
            for (int j = i; j > 99; j--) {
                
                // if product is palindrome and is greater than last recorded palindrome
                if (isPalindrome(i * j) && i * j > palindrome) {
                    palindrome = i * j;
                }
            }
        }
        return palindrome;
    }
}