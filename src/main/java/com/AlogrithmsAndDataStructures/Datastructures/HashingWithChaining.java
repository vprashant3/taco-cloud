package com.AlogrithmsAndDataStructures.Datastructures;

import com.google.common.hash.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class HashingWithChaining<T> {
    private HashMap<Integer, ArrayList<T>> hashMap = new HashMap<>();
    private static int BUCKE_STZE=32;

    private void add(T s) {
        ArrayList<T> strings = getArrayList(s);
        if(strings == null){
            ArrayList<T> newArrayList =  new ArrayList<>();
            newArrayList.add(s);
            hashMap.put(getHash(s),newArrayList);
        } else {
            strings.add(s);
        }
    }

    private boolean contains(T s) {
        ArrayList<T> strings = getArrayList(s);
        return strings.stream().anyMatch(i -> i == s);
    }


    private void remove(T s) {
        ArrayList<T> strings = getArrayList(s);
        strings.remove(s);
        hashMap.put(getHash(s),strings);

    }

    private ArrayList<T> getArrayList(T s){
        int hash = getHash(s);
        return hashMap.get(hash);

    }

    private int getHash(T s) {
       return Hashing.consistentHash(s.hashCode(), BUCKE_STZE);
    }

    public static void main(String[] args) {
        HashingWithChaining<String> hashing = new HashingWithChaining<>();
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
