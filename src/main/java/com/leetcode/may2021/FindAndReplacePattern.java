package com.leetcode.may2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    private String[] alphabets = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void main(String[] args) {
       String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
       String pattern = "abb";
       new FindAndReplacePattern().findAndReplacePattern(words,pattern);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
       String tPattern =  transformer(pattern);
       List<String> res  = new ArrayList<>();
       for(String word : words) {
           if(word.length() == tPattern.length()  && transformer(word).equals(tPattern)) {
               res.add(word);
           }
       }
       return res;
    }

    private String transformer(String input) {
        int pos = 0;
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("");
        for(String s : input.split("") ) {
            if(map.containsKey(s)) {
                sb.append(map.get(s));
            } else {
                String val =  alphabets[pos];
                map.put(s, val);
                sb.append(val);
                pos++;
            }
        }
        return sb.toString();
    }
}
