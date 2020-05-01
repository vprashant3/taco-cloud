package com.leetcode.AprilChallenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

    public static void main(String[] args) {
        String[] input =  {"duh","ill","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(input);

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
        Map<Integer,List<String>> res =  new HashMap<>();
        for(String s : strs) {
            char[] charArray =  s.toCharArray();
            int hash = 0;
            for(char ch :  charArray) {
                hash += (int)ch;
            }
            if(res.containsKey(hash)) {
                List<String> existingList =  res.get(hash);
                existingList.add(s);
            } else {
                List<String> newList =  new ArrayList<>();
                newList.add(s);
                res.put(hash,newList);
            }
        }
        Collection<List<String>> values = res.values();
        List<List<String>> resList =  new ArrayList<>();
        values.forEach( list -> resList.add(list));
        return resList;
    }


}
