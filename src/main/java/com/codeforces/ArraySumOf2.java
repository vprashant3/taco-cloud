package com.codeforces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ArraySumOf2 {

    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        int n = s.nextInt();
        int k =s.nextInt();

        int totalCells  =  n*n;
        int countToRemove = 0;
        HashSet<Integer> xSet = new HashSet<>();
        HashSet<Integer> ySet = new HashSet<>();

        while(k-- > 0) {
                int x = s.nextInt();
                int y = s.nextInt();
                countToRemove = 0;
                if(!xSet.contains(x)) {
                    countToRemove += (n - xSet.size());
                    xSet.add(x);
                }
                if(!ySet.contains(y)) {
                    countToRemove += (n - ySet.size());
                    ySet.add(y);
                }
                totalCells -= countToRemove - 1;
                if(totalCells > 0 ) {
                    System.out.print(totalCells+" ");
                }else {
                    System.out.print(0+" ");
                }

            }
        }



    }









