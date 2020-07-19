package com.CoreJava.DesignPatterns.Singleton;

import java.io.Serializable;

public class LazyInitializationNotThreadSafe implements Serializable, Cloneable {
    private static LazyInitializationNotThreadSafe instance;

    private LazyInitializationNotThreadSafe() {}

    public static LazyInitializationNotThreadSafe getInstance() throws InterruptedException {

        if(instance == null) {
            Thread.sleep(200);
            instance = new LazyInitializationNotThreadSafe();
        }
        return instance;
    }


    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
