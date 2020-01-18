package com.datastructures;

import com.google.common.hash.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class HashingWithChaining {
    private HashMap<Integer, ArrayList<String>> hashMap;
    private static int BUCKE_STZE=32;

    public HashingWithChaining() {
        hashMap = new HashMap<>();
    }
    public void add(String s) {
        ArrayList<String> strings = getArrayList(s);
        if(strings == null){
            ArrayList<String> newArrayList =  new ArrayList<>();
            newArrayList.add(s);
            hashMap.put(getHash(s),newArrayList);
        } else {
            strings.add(s);
        }
    }

    public boolean contains(String s) {
        ArrayList<String> strings = getArrayList(s);
        return strings.stream().anyMatch(i -> i.equalsIgnoreCase(s));
    }


    public void remove(String s) {
        ArrayList<String> strings = getArrayList(s);
        strings.remove(s);
        hashMap.put(getHash(s),strings);

    }

    private ArrayList<String> getArrayList(String s){
        int hash = getHash(s);
        return hashMap.get(hash);

    }

    private int getHash(String s) {
       return Hashing.consistentHash(s.hashCode(), BUCKE_STZE);
    }


}
