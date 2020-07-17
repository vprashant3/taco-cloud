package com.AlogrithmsAndDataStructures.Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternMatcher {

    private static String encodeString(String s) {
        StringBuilder res = new StringBuilder();
        int code = 0;
        Map<Character,Integer> encodingMap = new HashMap<>();

        for(char c: s.toCharArray()) {
            if(!encodingMap.containsKey(c)) encodingMap.put(c, code++);
            res.append(encodingMap.get(c));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String pattern = "xyy";
        List<String> inputs = Arrays.asList("abb","abc","bcc");

        String encodedPattern = encodeString(pattern);
        inputs.stream()
                .filter(x -> encodeString(x).equals(encodedPattern))
                .forEach(System.out::println);

    }

}
