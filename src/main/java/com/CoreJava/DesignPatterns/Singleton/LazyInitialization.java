package com.CoreJava.DesignPatterns.Singleton;

import java.io.Serializable;

public class LazyInitialization implements Serializable, Cloneable {
    private static  LazyInitialization instance;

    private LazyInitialization() {}

    public static  LazyInitialization getInstance() {

        if(instance == null) {
            synchronized (LazyInitialization.class) {
                if(instance == null) {
                    instance = new LazyInitialization();
                }
            }
        }
        return instance;
    }


    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
