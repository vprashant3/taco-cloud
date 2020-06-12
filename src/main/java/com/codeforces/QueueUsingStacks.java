package com.codeforces;

import com.datastructures.Stack;

// Queue is FIFO
public class QueueUsingStacks<T> {

    //LIFO
    Stack<T> s1 =  new Stack<>();
    Stack<T> s2 = new Stack<>();


    private void add(T t) {
        s1.push(t);
    }

    private T remove() {
        if(!s2.isEmpty()) return s2.pop();
        else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return  s2.pop();
        }

    }

    public static void main(String[] args) {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.add(1);
        queueUsingStacks.add(2);
        queueUsingStacks.add(3);


        System.out.println(queueUsingStacks.remove());
        System.out.println(queueUsingStacks.remove());
        System.out.println(queueUsingStacks.remove());


    }

}
