package com.AlogrithmsAndDataStructures.Recursion;

public class Print1ToN {

    public static void main(String[] args) {
        new Print1ToN().print(10);
    }

    private void  print(int n) {
        if(n >= 1) {
            print(n-1);
            System.out.println(n);
        }
    }
}
