package com.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public Queue() { }

    public Queue(T firstElement) {
        offer(firstElement);
    }

    public int size() { return  list.size();}

    public boolean isEmpty() {return list.size()==0;}

    private void offer(T firstElement) {
        list.addLast(firstElement);
    }

    public T poll() {
        return list.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
