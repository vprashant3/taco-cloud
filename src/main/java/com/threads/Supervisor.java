package com.threads;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Supervisor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> cal1 = () ->  {
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                System.out.println("call1 "+ i);
                sum += i;
            }
            return sum;
        };
        Callable<Integer> cal2 = () ->  {
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                System.out.println("call2 "+ i);
                sum += i;
            }
            return sum;
        };


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(cal1, cal2);
        List<Future<Integer>> futures = executorService.invokeAll(taskList);

        for(Future f : futures) {
            System.out.println(f.get());
        }
        executorService.shutdown();
    }




}
