package com.AlogrithmsAndDataStructures.Recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringSubset {
    public static void main(String[] args) {
        String[] subSetArr = new StringSubset().generateSubsetWithRecursion("abc");
        Arrays.stream(subSetArr).forEach(System.out::println);
    }

    private String[] generateSubsetWithRecursion(String abc) {
        return null;
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
