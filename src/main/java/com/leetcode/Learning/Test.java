package com.leetcode.Learning;

import com.leetcode.HelperClasses.ListNode;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
    }


    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> arrayList =  new ArrayList<>();
        while(head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        int[] integers =  arrayList.stream().mapToInt(Integer::intValue).toArray();
        int num = 0;
        int j = 0;
        for(int i = integers.length - 1;  i >= 0; i--, j++) {
            num += integers[i]* Math.pow(2,j);
        }
        return num;

    }


}
