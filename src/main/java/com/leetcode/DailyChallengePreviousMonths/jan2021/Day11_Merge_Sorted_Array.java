package com.leetcode.DailyChallengePreviousMonths.jan2021;

import java.util.Arrays;

public class Day11_Merge_Sorted_Array {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Day11_Merge_Sorted_Array().merge(nums1, 3, nums2, 3);
     }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int finalPos = m + n;
        while(m > 0 || n > 0) {
            if(m > 0 &&  n > 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[finalPos - 1] = nums1[m - 1];
                    m--;

                } else {
                    nums1[finalPos - 1] = nums2[n - 1];
                    n--;
                }
            } else if (m > 0) {
                nums1[finalPos - 1] = nums1[m - 1];
                m--;
            } else  if(n > 0) {
                nums1[finalPos - 1] = nums2[n - 1];
                n--;
            }
            finalPos--;
        }
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
