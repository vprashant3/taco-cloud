package com.leetcode.AprilChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Day2 {

    public static void main(String[] args) {
        int input = 5;
        System.out.println(findComplement(input));


    }

    public static boolean isHappy(int n) {
        int j = n;
        List<Integer> traversedElements =  new ArrayList<>();
        while(true) {
            if(traversedElements.contains(j)) return false;
            else traversedElements.add(j);
            j = sumOfIntegers(j);
            if(j==1) return true;
        }

    }

    public static int sumOfIntegers(int n) {
        int sum = 0;
        while(n !=0) {
            int digit = n%10;
            sum += digit*digit;
            n =  n/10;
        }
        return sum;
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> tempStore = new HashMap<>();
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);
            if(tempStore.containsKey(sortedString)) {
                List<String> list = tempStore.get(sortedString);
                list.add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                tempStore.put(sortedString,list);
            }

        }
        List<List<String>> res =  new ArrayList<>();
        tempStore.values().forEach(list -> res.add(list));
        return res;
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char pop = stack.pop();
                if(pop == '(' && c == ')') {}
                else if(pop == '[' && c == ']') {}
                else if (pop == '{' && c == '}') {}
                else return false;
            }

        }
        if(stack.empty()) return true;
        else return false;
    }


    public static int findComplement(int num) {
        int ones = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ ones;
    }


}
