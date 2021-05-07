package com.leetcode.DailyChallengePreviousMonths.jan2021;

import java.util.Arrays;

public class Day13_BoatsToSavePeople {

    public static void main(String[] args) {

    }

    public int numRescueBoats(int[] people, int limit) {
        if(people.length == 1) return 1;

        int count = 0;
        int i = 0 ;
        int j = people.length - 1;
        Arrays.sort(people);

        while(i <= j) {
            if((j-1 >= 0) && (people[j] + people[j -1] <= limit)) j -= 2;
            else if(people[j] + people[i] <= limit) { i++; j--;}
            else j--;
            count++;
        }
        return count;
    }
}
