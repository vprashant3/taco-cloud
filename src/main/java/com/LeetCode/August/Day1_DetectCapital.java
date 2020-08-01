package com.LeetCode.August;

public class Day1_DetectCapital {

    public static void main(String[] args) {
        System.out.println(new Day1_DetectCapital().detectCapitalUse("ggg"));
    }

    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;

        char[] charArr = word.toCharArray();

        boolean isFirstLetterCapitalized = false;
        if(charArr[0] >= 'A' && charArr[0] <= 'Z') isFirstLetterCapitalized = true;

        boolean areRestOfLettersAllCapitalized = true;
        boolean areRestOfLettersAlSmall = true;
        for(int i = 1; i < charArr.length; i++) {
            if(charArr[i] < 'A' || charArr[i] > 'Z') areRestOfLettersAllCapitalized = false;
            if(charArr[i] >= 'A' && charArr[i] <= 'Z') areRestOfLettersAlSmall = false;
        }

        if(isFirstLetterCapitalized && areRestOfLettersAllCapitalized) return true;
        if(isFirstLetterCapitalized && areRestOfLettersAlSmall) return true;
        if(!isFirstLetterCapitalized && areRestOfLettersAlSmall) return true;

        return false;
    }


}
