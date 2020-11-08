package com.AlogrithmsAndDataStructures.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StringSubset {
    public static void main(String[] args) {
        List<String> res =  new ArrayList<>();
        res.add("");
        new StringSubset().generateSubsetWithRecursion("abc", res);
        res.forEach(System.out::println);
    }

    private void generateSubsetWithRecursion(String input, List<String> res) {
        String firstChar = input.substring(0,1);
        List<String> temp = new ArrayList<>();
        for(String s : res) {
            temp.add(s.concat(firstChar));
        }
        res.addAll(temp);
        if(input.length() == 1) {
            return;
        } else {
            generateSubsetWithRecursion(input.substring(1), res);
        }

    }

    private String[] generateSubsetWithoutRecursion(String input) {
        Set<String> finalSet =  new HashSet<>();
        finalSet.add("");
        char[] charArray = input.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            Iterator<String> strings =  finalSet.iterator();
            Set<String> tempSet =  new HashSet<>();
           while(strings.hasNext()) {
               String s = strings.next() + charArray[i];
               tempSet.add(s);
           }
           finalSet.addAll(tempSet);
        }
        return finalSet.stream().toArray(String[]::new);

    }


}
