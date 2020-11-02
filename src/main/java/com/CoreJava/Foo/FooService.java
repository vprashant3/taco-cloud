package com.CoreJava.Foo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FooService {


    public List<String> getAll() {
        return new ArrayList<>(Arrays.asList(new String[]{"hi", "there"}));
    }
}
