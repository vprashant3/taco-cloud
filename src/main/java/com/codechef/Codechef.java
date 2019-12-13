package com.codechef;

import java.util.Scanner;

public class Codechef {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        try {
            Scanner sc = new Scanner(System.in);
            int numTestCases = sc.nextInt();

            for(int i = 0; i < numTestCases; i++) {
                int inputSize = sc.nextInt();
                int countOfZeroes = 0;
                int countOfTwos = 0;
                for(int j = 0; j < inputSize; j++) {
                    double input = sc.nextDouble();
                    if(input == 2) ++countOfTwos;
                    if(input == 0) ++countOfZeroes;
                }
                int result =  getCountOfCombinations(countOfTwos) + getCountOfCombinations(countOfZeroes);
                System.out.println(result);

            }

        } catch(Exception e) {
            return;
        }
    }

    private static int getCountOfCombinations(int input) {
        System.out.println(input);
        return nCr(input, 2);
    }

    private static int nCr(int n, int r)
    {
        return fact(n) / ((fact(r) * fact(n - r)));
    }

    private static int fact(int n)
    {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
