package com.codingroundpatterns.twoPointers;

public class ValidPalindromeII {
    public static void main(String[] args) {
        isPalindrome("radars");
    }

    public static boolean isPalindrome(String s) {
       int start = 0;
       int end = s.length() - 1;
       int numOfCharSkipped = 0;
       while (start < end) {
           if(s.charAt(start) == s.charAt(end)) {
               start ++;
               end --;
           } else if (s.charAt(start+1) == s.charAt(end)) {
               start+=2;
               end--;
               numOfCharSkipped++;
           } else if (s.charAt(start) == s.charAt(end - 1)) {
               start++;
               end-=2;
               numOfCharSkipped++;
           } else {
             return false;
           }
           if(numOfCharSkipped > 1) return false;
       }
        return true;
    }
}
