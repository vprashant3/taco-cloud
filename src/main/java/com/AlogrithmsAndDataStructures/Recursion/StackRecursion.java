package com.AlogrithmsAndDataStructures.Recursion;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackRecursion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        deleteMiddleElementUsingRecursion(stack,(stack.size()/2 + 1));
        stack.forEach(System.out::println);


    }

    private static Stack<Integer> deleteMiddleElementUsingRecursion(Stack<Integer> stack, int mid) {
        if(stack.size() == mid) {
            stack.pop();
            return stack;
        } else {
            int top = stack.pop();
            deleteMiddleElementUsingRecursion(stack, mid);
            stack.push(top);
        }
        return stack;
    }

    private static Stack<Integer> sortStackUsingRecursion(Stack<Integer> stack) {
        Stack<Integer> mergedStack;
        if(stack.size() == 1) return stack;
        else {
            int top = stack.pop();
            Stack<Integer> sortedStack =  sortStackUsingRecursion(stack);
            mergedStack = getMergedStackUsingRecursion(sortedStack, top);
        }
        return mergedStack;
    }

    private static Stack<Integer> getMergedStackUsingRecursion(Stack<Integer> sortedStack, int top) {
        if(sortedStack.isEmpty()) sortedStack.push(top);
        else if(sortedStack.peek() <= top) sortedStack.push(top);
        else {
            int pop =  sortedStack.pop();
            getMergedStackUsingRecursion(sortedStack, top);
            getMergedStackUsingRecursion(sortedStack, pop);
        }
        return sortedStack;
    }

    private static Stack<Integer> getMergedStack(Stack<Integer> sortedStack, int top) {
        List<Integer> elementsPopped = new ArrayList<>();
        while(!sortedStack.isEmpty() && sortedStack.peek() > top) {
            elementsPopped.add(sortedStack.pop());
        }
        sortedStack.add(top);
        for(int i = elementsPopped.size() - 1; i>=0; i--) {
            sortedStack.push(elementsPopped.get(i));
        }
        return sortedStack;
    }


}
