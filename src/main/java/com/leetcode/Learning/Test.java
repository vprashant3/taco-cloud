package com.leetcode.Learning;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(wordBreak(s, wordDict));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null  || wordDict.size() ==0 ) return false;



        return false;
    }

}
