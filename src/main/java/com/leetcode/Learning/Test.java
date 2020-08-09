package com.leetcode.Learning;

import com.leetcode.HelperClasses.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        System.out.println(new Test().findKthPositive(arr, k));
    }

    public int findKthPositive(int[] arr, int k) {
        int curNum = 1;
        int curMissingCount = 0;
        for(int i = 0; i < arr.length; i++) {
            while (curNum < arr[i]) {
                curNum++;
                curMissingCount++;
                if(curMissingCount == k) return --curNum;
            }
            curNum++;
        }
        while(curMissingCount <= k) {
            curNum++;
            curMissingCount++;
            if(curMissingCount == k) return --curNum;
        }
        return 0;
    }





}
