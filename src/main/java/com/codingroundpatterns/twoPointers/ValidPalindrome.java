package com.codingroundpatterns.twoPointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // Write your code here
        // Tip: You may use the code template provided
        // in the TwoPointers.java file
        int start = 0;
        int end =  s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}
