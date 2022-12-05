package com.educative.io.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    public static ArrayDeque<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
        Integer[] numsArray = nums.toArray(new Integer[0]);
        ArrayDeque<Integer> result = new ArrayDeque<>();
        // write yout code here

        Deque<Integer> curWindow = new ArrayDeque<>();
        for(int  i = 0; i < windowSize; i++) {
            if(curWindow.peekLast() == null) curWindow.add(numsArray[i]);
            else if(curWindow.peekLast() > numsArray[i]) curWindow.addLast(numsArray[i]);
            else {
                while(curWindow.peekLast() !=  null && curWindow.peekLast() <= numsArray[i]) {
                    curWindow.removeLast();
                }
                curWindow.addLast(numsArray[i]);
            }
        }
        if(curWindow.peekFirst() != null) result.add(curWindow.peekFirst());
        if(curWindow.size() == windowSize) curWindow.removeFirst();
        for(int i = windowSize; i < nums.size(); i++) {
            if(curWindow.peekLast() !=null && curWindow.peekLast() > numsArray[i]) curWindow.addLast(numsArray[i]);
            else {
                while(curWindow.peekLast() !=  null && curWindow.peekLast() <= numsArray[i]) {
                    curWindow.removeLast();
                }
                curWindow.addLast(numsArray[i]);
            }
            if(curWindow.peekFirst() != null) result.add(curWindow.peekFirst());
            if(curWindow.size() == windowSize) curWindow.removeFirst();
        }
        return result;
    }




}
