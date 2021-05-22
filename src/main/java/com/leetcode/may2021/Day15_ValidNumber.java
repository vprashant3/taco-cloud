package com.leetcode.may2021;

public class Day15_ValidNumber {

    public boolean isNumber(String s) {
        char[] chars =  s.toCharArray();

        for(int  i = 0; i < chars.length; i++) {
            if(isCharPlusOrMinus(chars[i])) {
                if(i== 0) continue;
                else return false;
            }
            if(isCharADot(chars[i]) )
                if(isCharANumber(chars[i])) continue;



        }
        return true;

    }

    boolean isCharANumber(char c) {
        try {
            Character.getNumericValue(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    boolean isCharPlusOrMinus(char c) {
        return Character.toString(c).equals("+") || Character.toString(c).equals("-");
    }

    boolean isCharADot(char c) {
        return Character.toString(c).equals(".");
    }
}
