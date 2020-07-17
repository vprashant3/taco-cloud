package com.CoreJava.FunctionalJava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindTopEntries {
    // using as register
    static HashMap<String,Integer> register = new HashMap<>();


    public static void main(String[] args) {
        // make entry for each customer
        makeEntry("Ram","123");
        makeEntry("Shyam", "345");
        makeEntry("Ram", "123");

        // sort entry register and get the top element, similarly can take top n elements
        List<Map.Entry<String, Integer>> collect = register.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(1).collect(Collectors.toList());

        Map.Entry<String, Integer> stringIntegerEntry = collect.get(0);
        // verifying ram is top element has he visited twice
        assert stringIntegerEntry.getKey().equals("Ram_123") ? true : false;


    }

    public static void makeEntry(String user, String number) {
        // create key using user name and number , keep count
        String key = user+"_"+number;
        if(register.containsKey(key)) {
            register.put(key,register.get(key)+1);
        } else {
            register.put(key,1);
        }
    }
}
