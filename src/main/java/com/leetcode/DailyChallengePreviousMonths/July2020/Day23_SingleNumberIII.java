package com.leetcode.DailyChallengePreviousMonths.July2020;

import java.util.HashSet;
import java.util.Set;

public class Day23_SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int i :  nums) {
            if(res.contains(i)) res.remove(i);
            else res.add(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
