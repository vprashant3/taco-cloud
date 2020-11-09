package com.AlogrithmsAndDataStructures.Recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringSubset {
    public static void main(String[] args) {
        Set<String> res =  new HashSet<>();
        new StringSubset().permutationWithSpaces("abc" ,0, res);
        res.forEach(System.out::println);
    }

    private void permutationWithSpaces(String input, int pos, Set<String> res) {
        if(pos == input.length()) return;
        String s1 = input.substring(0,pos).concat(" ").concat(input.substring(pos)).trim();
        res.add(s1);
        permutationWithSpaces(input, pos + 1, res);
    }

    private void generateSubsetWithRecursion(String input, Set<String> res) {
        if(input == null || input.length() == 0) return;
        String firstChar = input.substring(0,1);
        Set<String> temp = new HashSet<>();
        for(String s : res) {
            temp.add(s.concat(firstChar));
        }
        res.addAll(temp);
        generateSubsetWithRecursion(input.substring(1), res);
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
