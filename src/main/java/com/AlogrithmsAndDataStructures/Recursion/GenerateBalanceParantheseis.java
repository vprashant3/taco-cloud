package com.AlogrithmsAndDataStructures.Recursion;

import java.util.HashSet;
import java.util.Set;

public class GenerateBalanceParantheseis {

    public static void main(String[] args) {
        Set<String> strings =  new HashSet<>();
        int num = 3;
        String output = "";
        generate(3, 3, output);
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
}
