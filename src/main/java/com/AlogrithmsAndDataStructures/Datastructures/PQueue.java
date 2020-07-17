package com.AlogrithmsAndDataStructures.Datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PQueue<T extends Comparable<T>> {

    private int heapSize = 0;
    private int heapCapacity = 0;
    private List<T> heap;

    private Map<T, TreeSet<T>> map = new HashMap<>();

    public PQueue() {
        this(1);
    }

    public PQueue(int size ) {
        heap = new ArrayList<>(size);
    }

    public PQueue(T[] elems) {
        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<>(heapCapacity);

        heap.addAll(Arrays.asList(elems).subList(0, heapSize));

        for(int i = Math.max(0, (heapSize/2)-1); i>=0; i--) sink(i);

    }

    private void sink(int i) {
    }

    private void mapAdd(T elem, int i) {
    }

    private boolean isEmpty() {return  heapSize == 0;}

    public int size() {return  heapSize;}


}
