package com.AlogrithmsAndDataStructures.Recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int discNum = 4;
        towerOfHanoi(discNum, 'A', 'C', 'B');
    }

    private static void towerOfHanoi(int discNum, char fromRod, char toRod, char auxRod) {
        if(discNum == 1) {
            System.out.println("Move Disc " + discNum +  " from "+ fromRod +" to "+ toRod);
            return;
        }
        towerOfHanoi(discNum - 1, fromRod , auxRod, toRod);
        System.out.println("Move Disc " + discNum +  " from "+ fromRod +" to "+ toRod);
        towerOfHanoi(discNum - 1, auxRod , toRod, fromRod);
    }
}
