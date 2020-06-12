package com.threads;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Worker2 implements Runnable {
    public void run() {
        IntStream.range(1,10)
                .forEach( i -> {
                    try {
                        Thread.sleep((long) Math.random());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("worker 2 working on " + i);
                }
        );
    }
}
