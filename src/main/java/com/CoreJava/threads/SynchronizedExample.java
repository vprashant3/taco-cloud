package com.CoreJava.threads;

import java.util.stream.IntStream;

public class SynchronizedExample {

    final static SynchronizedExample syn =  new SynchronizedExample();

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                syn.printNumbers(3);
            }
        };
        new Thread(r, "t1").start();
        new Thread(r, "t2").start();




    }

    private  void printNumbers(int n) {
        synchronized (this) {
            IntStream.range(1,n).forEach(i -> {
                System.out.println(Thread.currentThread().getName()+" "+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}
