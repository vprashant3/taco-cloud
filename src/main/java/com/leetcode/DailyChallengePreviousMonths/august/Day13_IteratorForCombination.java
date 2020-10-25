package com.leetcode.DailyChallengePreviousMonths.august;


import java.util.PriorityQueue;

public class Day13_IteratorForCombination {
    private static PriorityQueue<String> combinations = new PriorityQueue<>();


    public static void main(String[] args) {
        new Day13_IteratorForCombination("abc", 2);
        System.out.println("here");

    }

    public Day13_IteratorForCombination(String characters, int combinationLength) {

        for(int i = 0; i < Math.pow(characters.length(), 2); i++) {
            StringBuilder sb = new StringBuilder();
            String binaryString = Integer.toBinaryString(i);
            for(int j = binaryString.length() - 1; j >=0; j--) {
                if(binaryString.charAt(j) == '1') sb.append(characters.charAt(j));
            }
            combinations.add(sb.toString());
        }

    }

    public String next() {
        return "";
    }

    public boolean hasNext() {
        return  false;
    }
}
