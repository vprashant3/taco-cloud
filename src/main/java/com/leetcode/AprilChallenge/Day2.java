package com.leetcode.AprilChallenge;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {

        System.out.println(isHappy(19));
//        System.out.println(sumOfIntegers(19));

    }

    public static boolean isHappy(int n) {
        int j = n;
        List<Integer> traversedElements =  new ArrayList<>();
        while(true) {
            if(traversedElements.contains(j)) return false;
            else traversedElements.add(j);
            j = sumOfIntegers(j);
            if(j==1) return true;
        }

    }

    public static int sumOfIntegers(int n) {
        int sum = 0;
        while(n !=0) {
            int digit = n%10;
            sum += digit*digit;
            n =  n/10;
        }
        return sum;
    }


}
