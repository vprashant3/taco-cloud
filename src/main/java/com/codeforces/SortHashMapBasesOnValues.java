package com.codeforces;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHashMapBasesOnValues {

    public static void main(String[] args) {
        HashMap<String,Integer> map =  new HashMap<>();
        map.put("two",2);
        map.put("one",1);
        map.put("three",3);

        List<Map.Entry<String, Integer>> sorted = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).collect(Collectors.toList());

        sorted.stream().forEach(e -> System.out.println(e.getValue()));

    }
}
