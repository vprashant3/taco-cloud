package com.codechef;

import java.util.Scanner;
import java.util.stream.IntStream;

public class WATSCORE {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        try {
            Scanner sc = new Scanner(System.in);
            int numTestCases = sc.nextInt();
            for(int i = 0; i < numTestCases; i++) {
                int inputSize = sc.nextInt();
                int[] solArray = new int[8];
                for(int j = 0; j < inputSize; j++) {
                    int problem =  sc.nextInt();
                    int score = sc.nextInt();
                    if(problem <=8 && solArray[problem-1] < score) solArray[problem-1] = score;
                }
                System.out.println(IntStream.of(solArray).sum());

            }

        } catch(Exception e) {
            throw new Exception();
        }
    }
}
