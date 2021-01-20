package com.leetcode.jan2021;



import java.util.Stack;

public class Day19_ValidParenthesis {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if(stack.isEmpty()) return false;
                if(chars[i] == ')' && !stack.pop().equals('(')) return false;
                if(chars[i] == '}' && !stack.pop().equals('{')) return false;
                if(chars[i] == ']' && !stack.pop().equals('[')) return false;
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
