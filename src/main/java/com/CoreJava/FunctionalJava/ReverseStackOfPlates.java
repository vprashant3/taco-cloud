package com.CoreJava.FunctionalJava;

import com.AlogrithmsAndDataStructures.Datastructures.Stack;

public class ReverseStackOfPlates {


    public static void main(String[] args) {
        // Create an integer stack and push all elements/plates so that 1 becomes bottom
        Stack<Integer> stack =  new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // call reverse stack
        reverseStack(stack);

        // verify that bottom most element has become top
        assert stack.pop() == 3 ? true : false;
        assert stack.pop() == 2 ? true : false;
        assert stack.pop() == 1 ? true : false;

    }

    private static void reverseStack(Stack<Integer> stack) {
        for (int i = 0; i < stack.size(); i++)
        {
            Integer targetElement = stack.pop();
            // take each element from the stack , pop it and put it the bottom
            // O(n) time complexity has looping through one
            // O(1) space complexity as not using any extra space
            ReverseStackStep(stack, stack.size() - i, 0, targetElement);
        }

    }

    private static void ReverseStackStep(Stack stack, int limit, int currentLevel, Integer targetElement)
    {
        if (currentLevel == limit)
        {
            stack.push(targetElement);
        }
        else
        {
            Integer element = (Integer) stack.pop();
            ReverseStackStep(stack, limit, currentLevel + 1, targetElement);
            stack.push(element);
        }
    }
}
