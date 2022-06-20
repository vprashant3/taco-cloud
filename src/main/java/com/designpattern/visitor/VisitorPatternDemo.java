package com.designpattern.visitor;

import java.util.Arrays;
import java.util.stream.IntStream;

public class VisitorPatternDemo {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

    public int[] runningSum(int[] nums) {
       return IntStream.range(0, nums.length).map(i->i==0?nums[i]: (nums[i] += nums[i - 1])).toArray();
    }
}