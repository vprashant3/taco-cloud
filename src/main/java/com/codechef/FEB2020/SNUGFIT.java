package com.codechef.FEB2020;

import java.util.Arrays;
import java.util.Scanner;

public class SNUGFIT {

    public static void main (String[] args) throws java.lang.Exception {

        try {
            Scanner sc = new Scanner(System.in);
            int numTestCases = sc.nextInt();
            for(int i=0; i<numTestCases; i++) {
                int arrSize=sc.nextInt();
                int[] input1 = new int[arrSize];
                int[] input2 = new int[arrSize];
                for(int j=0; j<arrSize; j++) {
                    input1[j] = sc.nextInt();
                }
                for(int j=0; j<arrSize; j++) {
                    input2[j] = sc.nextInt();
                }
                Arrays.sort(input1);
                Arrays.sort(input2);
                int sum = 0;
                for(int j=0; j<arrSize; j++) {
                    sum += Math.min(input1[j],input2[j]);
                }
                System.out.println(sum);

            }

        } catch (Exception e) {
            throw new Exception();
        }
    }
}
