package com.AlogrithmsAndDataStructures.DynamicProgramming;

public class ZeroOneKnapSack {

    public static void main(String[] args) {
        int[] value  = {60,100,120};
        int[] weight =  {10,20,30};
        int W = 50;
        System.out.println(new ZeroOneKnapSack().recursiveSolution(value, weight, W, value.length));

    }

    private int recursiveSolution(int[] value, int[] weight, int w, int n) {
        //Base Condition
        if(n == 0|| w == 0 ) return 0;

        // Choice Diagram
        if(w < weight[n-1]) return  recursiveSolution(value, weight, w, n-1);
        else return Math.max((value[n-1]+ recursiveSolution(value, weight, w-weight[n-1] , n-1)), recursiveSolution(value, weight, w, n-1));
    }


}
