package com.AlogrithmsAndDataStructures.Recursion;

public class CaseChange {

    public static void main(String[] args) {
        generateAllCaseChange("ab", "");
    }

    private static void generateAllCaseChange(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        String firstChar = input.substring(0, 1);
        String newInput = input.substring(1);
        String output1 = output.concat(firstChar);
        generateAllCaseChange(newInput, output1);
        String output2 =  output.concat(firstChar.toUpperCase());
        generateAllCaseChange(newInput, output2);

    }


}
