package com.FunctionalJava;

import java.util.HashMap;
import java.util.HashSet;

public class FindDuplicateBead {

    public static void main(String[] args) {
        // array to simulate beads which has only one duplicate 12
        int[] beads = {12,2,3,12,4,5};

        HashSet<Integer> set = new HashSet<>();

        // looping through array once hence time complexity O(n)
        for(int i : beads) {
            // contains is O(1)
            if(set.contains(i)) {
                System.out.println("duplicate bead found : "+ i);
                // once duplicate found break as no more duplicates exist
                break;
            } else  {
                set.add(i);
            }
        }
    }
}
