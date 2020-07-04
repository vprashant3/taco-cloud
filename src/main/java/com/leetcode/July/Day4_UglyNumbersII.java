package com.leetcode.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Day4_UglyNumbersII {

    public static void main(String[] args) {
        isUgly(6);
    }

    //using priorityQueue
    public int nthUglyNumber(int n) {
        int[] primes = {2,3, 5};
        PriorityQueue<Long> q=new PriorityQueue<>();
        int count=1; long num=1;
        for(int i:primes){q.add((long) i);}
        while(count<n){
            num=q.poll();
            if(q.isEmpty()||num!=q.peek()){
                count++;
                for(int i:primes){
                    q.add(num*i);
                }
            }
        }
        return (int)num;

    }

    //logical approach
    public int nthUglyNumberLogical(int n) {
        if(n <= 0) return 0;
        List<Integer> ugly =  new ArrayList<>();
        ugly.add(1);

        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;

        while (ugly.size() < n ) {
            int by2 = ugly.get(twoIndex) * 2;
            int by3 = ugly.get(threeIndex) * 3;
            int by5 = ugly.get(fiveIndex) * 5;

            int min =  Math.min(by2, Math.min(by3, by5));
            ugly.add(min);

            if(min == by2) twoIndex++;
            if(min == by3) threeIndex++;
            if(min == by5) fiveIndex++;
        }

        return ugly.get(ugly.size() - 1);

    }

    public static boolean isUgly(int num) {
        if(num == 0) return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}


