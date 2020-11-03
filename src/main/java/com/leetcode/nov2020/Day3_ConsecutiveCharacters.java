package com.leetcode.nov2020;

public class Day3_ConsecutiveCharacters {

    public static void main(String[] args) {

    }

    public int maxPower(String s) {
        if(s.length() == 1) return 1;
        char[] charArray = s.toCharArray();
        int curLength = 1;
        int maxLength = 0;
        for(int i = 1; i  < charArray.length; i++) {
            if(charArray[i] == charArray[i - 1]) curLength++;
            else {
                maxLength = Math.max(maxLength, curLength);
                curLength = 1;
            }
        }
        return Math.max(maxLength, curLength);
    }
}
