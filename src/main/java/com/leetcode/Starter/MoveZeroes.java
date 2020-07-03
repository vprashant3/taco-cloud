package com.leetcode.Starter;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums  = {2, 7, 11, 15};
        int target = 9;
//        moveZeroes(input);
//        useIndex(input);
//        List<Integer> disappearedNumbers = findDisappearedNumbers(input);

        int[] ints = twoSum(nums, target);

        Arrays.stream(ints).forEach(x->System.out.println(x));


    }

    private static void useIndex(int[] nums) {
        int insertPos =0;

        for(int i : nums) {
            if(i != 0) {
                nums[insertPos++] = i;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        for(int i : nums) {
            System.out.println(i);
        }

    }

    public static void moveZeroes(int[] nums) {
        for(int i =0; i< nums.length; i++) {
            int j = 0;
            while (i-j-1 >= 0 && nums[i - j] != 0 && nums[i - j - 1] == 0) {
                int temp =  nums[i-j];
                nums[i-j] = nums[i-j-1];
                nums[i-j-1] = temp;
                j++;
            }
        }
        for(int i : nums) {
            System.out.println(i);
        }
    }

    private static void swap(int[] nums, int i, int i1) {
            int temp =  nums[i];
            nums[i] = nums[i1];
            nums[i1] = temp;
    }

    public static int majorityElement(int[] nums) {
        int majorityCandidate = nums[0];
        int majorityCandidateCount = 0;

        for(int i : nums) {
            if(i == majorityCandidate) {
                majorityCandidateCount++;
            } else {
                majorityCandidateCount--;
                if(majorityCandidateCount <= 0) {
                    majorityCandidate = i;
                    majorityCandidateCount = 1;
                }
            }
        }
        return majorityCandidate;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingList =  new LinkedList<>();

        for (int i=0; i<nums.length;i++) {
           int  val = Math.abs(nums[i])-1;
           if(nums[val]>0) {
               nums[val] = -(nums[val]);
           }
        }

        for (int i=0; i<nums.length;i++) {
            if(nums[i]>0) missingList.add(i+1);

        }


            return missingList;
    }


    public static int maxProfit(int[] prices) {
        int max_so_far = 0;
        int max_curr = 0;

        for(int i =1; i < prices.length; i++ ) {
            max_curr = Math.max(0, max_curr + prices[i] - prices[i-1]);
            max_so_far = Math.max(max_curr,max_so_far);

        }


        return max_so_far;
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map =  new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int curVal =  nums[i];
            int compVal = target - curVal;
            if(map.containsKey(compVal)) return new int[] {i,map.get(compVal)};
            else  map.put(nums[i], i);
        }

        return new int[] {0,0};
    }



}
