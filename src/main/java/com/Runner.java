package com;

import com.datastructures.HashingWithChaining;

public class Runner {

    public static void main(String[] args) {
        HashingWithChaining hashing = new HashingWithChaining();
        hashing.add("hi");
        hashing.add("there");
        hashing.add("hi");

        System.out.println(hashing.contains("hi"));
        System.out.println(hashing.contains("there"));
        hashing.remove("hi");
        System.out.println(hashing.contains("hi"));
        hashing.remove("hi");
        System.out.println(hashing.contains("hi"));



    }
}
