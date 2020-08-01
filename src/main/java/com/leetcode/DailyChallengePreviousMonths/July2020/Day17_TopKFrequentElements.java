package com.leetcode.DailyChallengePreviousMonths.July2020;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day17_TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        new Day17_TopKFrequentElements().topKFrequent(nums, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(count::get));

        PriorityQueue<Integer> queue = new PriorityQueue <>((key1, key2) -> count.get (key2) - count.get (key1));
        queue.addAll (count.keySet ());

        int[] topKList = new int[k];
        for (int i = 0; i < k; i++) {
            topKList[i] = queue.poll ();
        }

        return topKList;
    }
}

