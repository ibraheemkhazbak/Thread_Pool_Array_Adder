package com.khazbak;

import com.khazbak.array.ArrayFiller;
import com.khazbak.thread.ThreadPool;
import com.khazbak.time.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main{
    static ExecutorService executor = Executors.newCachedThreadPool();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] numbersArray= new int[100000000];

        ArrayFiller filler = new ArrayFiller();
        filler.randomFill(numbersArray);

        ThreadPool calculatorPool= new ThreadPool();
        StopWatch stopWatch=new StopWatch();

        stopWatch.start();
        Future<Long> firstThreadOutput = calculatorPool.arraySum(numbersArray,0,numbersArray.length/2);
        Future<Long> secondThreadOutput =  calculatorPool.arraySum(numbersArray,numbersArray.length/2,numbersArray.length);
        long result = getFutureSum(firstThreadOutput,secondThreadOutput);
        stopWatch.stop();
        System.out.println("2 Threads Finished in " +stopWatch.getTimeInSeconds()+ " seconds, Result is "+ result);

        stopWatch.reset();
        stopWatch.start();
        Future<Long> singleThreadOutput = calculatorPool.arraySum(numbersArray,0,numbersArray.length);
        result = singleThreadOutput.get();
        stopWatch.stop();
        System.out.println("Single Thread Finished in " +stopWatch.getTimeInSeconds()+ " seconds, Result is "+ result);
        return;




    }

    private static long getFutureSum(Future<Long> firstFuture,Future<Long> secondFuture) throws ExecutionException, InterruptedException {
            long firstResult = firstFuture.get();
            long secondResult = secondFuture.get();

            return firstResult+secondResult;
    }

   }
