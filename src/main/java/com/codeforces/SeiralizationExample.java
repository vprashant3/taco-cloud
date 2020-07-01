package com.codeforces;

import java.io.Serializable;

public class SeiralizationExample implements Serializable {

    private static final long serialVersionUID = 2L;

    private final String name;

    private final transient int number;

    public SeiralizationExample(String name, int number) {
        this.name = name;
        this.number = number;
    }

    private void writeObject() {

    }
}