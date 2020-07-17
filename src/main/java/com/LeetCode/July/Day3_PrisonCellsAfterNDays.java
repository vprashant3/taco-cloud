package com.LeetCode.July;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day3_PrisonCellsAfterNDays {

    public static void main(String[] args) {
       int[] cells = {1,0,0,1,0,0,1,0};
       int N = 1000000000;
       int[] res = prisonAfterNDays(cells, N);
        Arrays.stream(res).forEach(System.out::print);
    }




    // brute force solution;
    public static int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> hashSet = new HashSet<>();
        boolean hasCycle = false;
        int cycle = 0;
        int[] curDay = cells;
        int[] nextDay  = new int[cells.length];
        for (int i = 0; i < N; i++) {
            nextDay = nextDay(curDay);
            String key =  Arrays.toString(nextDay);
            if(!hashSet.contains(key)) {
                hashSet.add(key);
                cycle++;
            } else {
                hasCycle =  true;
                break;
            }
            curDay = nextDay;
        }
        if(hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; i++) {
                nextDay = nextDay(curDay);
                curDay = nextDay;
            }
        }
        return curDay;

    }

    private static int[] nextDay(int[] curDay) {
        int[] nextDay = new int[curDay.length];
        for(int i = 1; i < curDay.length-1; i++) {
            int left =   curDay[i-1];
            int right =  curDay[i+1];
            if(left == right) nextDay[i] = 1;
            else nextDay[i] = 0;
        }
        return nextDay;
    }
}
