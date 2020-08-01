package com.com.CoreJava.DesignPatterns.Singleton;


import com.CoreJava.DesignPatterns.Singleton.LazyInitialization;
import com.CoreJava.DesignPatterns.Singleton.LazyInitializationNotThreadSafe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {

    @Test
    public void testGetInstanceReturnsSameObject() {
        LazyInitialization lz1 =  LazyInitialization.getInstance();
        LazyInitialization lz2 =  LazyInitialization.getInstance();
        Assertions.assertSame(lz1, lz2);
    }

    @Test
    public void testBreakSingletonUsingReflection() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class lazyInitClass = Class.forName("com.CoreJava.DesignPatterns.Singleton.LazyInitialization");
        Constructor<LazyInitialization> lazyInitializationConstructor =  lazyInitClass.getDeclaredConstructor();
        lazyInitializationConstructor.setAccessible(true);
        LazyInitialization lz1 =  lazyInitializationConstructor.newInstance();
        LazyInitialization lz2 = lazyInitializationConstructor.newInstance();
        Assertions.assertNotSame(lz1, lz2);
    }

    @Test
    public void testBreakSingletonUsingSerialization() throws IOException, ClassNotFoundException {
        LazyInitialization lz1 =  LazyInitialization.getInstance();
        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("/tmp/lz1.ser"));
        oos.writeObject(lz1);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/lz1.ser"));
        LazyInitialization lzDeSer = (LazyInitialization) ois.readObject();
        ois.close();
        //our singleton has read resolve to avoid breaking through
        Assertions.assertNotSame(lz1, lzDeSer);
    }


    @Test
    public void testBreakSingletonUsingCloning() throws CloneNotSupportedException {
        LazyInitialization lz1 =  LazyInitialization.getInstance();
        LazyInitialization clone = (LazyInitialization) lz1.clone();
        Assertions.assertNotSame(lz1, clone);
    }

    @Test
    public void testBreakNonThreadSafeSingleTonUsingMultiThreading() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<LazyInitializationNotThreadSafe>  callable1 = LazyInitializationNotThreadSafe::getInstance;
        Callable<LazyInitializationNotThreadSafe>  callable2 = LazyInitializationNotThreadSafe::getInstance;
        executorService.submit(callable1);
        executorService.submit(callable2);
        LazyInitializationNotThreadSafe call = callable1.call();
        LazyInitializationNotThreadSafe call1 = callable2.call();
        executorService.shutdown();
        Assertions.assertNotSame(call,call1);
    }

}
