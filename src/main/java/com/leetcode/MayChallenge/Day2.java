package com.leetcode.MayChallenge;

import java.util.HashSet;
import java.util.Set;

public class Day2 {

    public static void main(String[] args) {
        String J =  "aAb";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J,S));

    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(char c : J.toCharArray()) set.add(c);
        for(char c : S.toCharArray()) {
            if(set.contains(c))
                ans++;
        }
        return ans;
    }
}
