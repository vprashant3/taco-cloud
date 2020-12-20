package com.AlogrithmsAndDataStructures.Recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GenerateBalanceParantheseis {

    public static void main(String[] args) {
      int[] input =  {0,1,0,2,0,1,2,0};
        int[] ints = new GenerateBalanceParantheseis().sortArray(input);

        Arrays.stream(ints).forEach(System.out::println);

    }

    private static void generate(int openRemaining, int closedRemaining, String output) {
        if(openRemaining == 0 && closedRemaining == 0) {
            System.out.println(output);
            return;
        }
        if(openRemaining == closedRemaining) {
            generate(openRemaining - 1, closedRemaining, output.concat("("));
        } else {
            if(openRemaining > 0) {
                generate(openRemaining - 1, closedRemaining, output.concat("("));
            }
            if(closedRemaining > openRemaining && closedRemaining > 0) {
                generate(openRemaining, closedRemaining - 1, output.concat(")"));
            }
        }
    }



    // key idea here is sort the arrays then swap adjacent elements to get wave form
    // time complexity would would O(nlogn) and space complexity is connstant as no additional memory is used.
    int[] sortArray(int[] input){
        // sorting is nlogn
        Arrays.sort(input);
        for(int i = 0; i < input.length - 1; i = i + 2) {
            int temp = input[i];
            input[i] = input[i+1];
            input[i + 1] = temp;
        }
        return a;
    }

}
