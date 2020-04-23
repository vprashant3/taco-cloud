package com;

import com.datastructures.HashingWithChaining;

import java.util.Optional;
import java.util.stream.IntStream;

public class Runner {

    public static void main(String[] args) {
        Optional<Boolean> aBoolean = Optional.ofNullable(false);

        aBoolean.ifPresent(x -> System.out.println("true"));

    }




    private static int next2Power(int capacity) {
        return Integer.highestOneBit(capacity) << 1;
    }
}
