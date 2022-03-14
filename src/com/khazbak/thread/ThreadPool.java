package com.khazbak.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    ExecutorService executor= Executors.newCachedThreadPool();

    public Future<Long> arraySum(int[] array,int leftIndex,int rightIndex){
        return executor.submit(() -> {
            long sum=0;
            for (int i = leftIndex; i < rightIndex; i++) {
                sum+=array[i];
             }
            return sum;
        });
    }
}
