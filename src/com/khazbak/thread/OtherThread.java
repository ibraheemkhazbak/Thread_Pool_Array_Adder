package com.khazbak.thread;

import com.khazbak.array.ArrayFiller;

import javax.swing.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OtherThread extends Thread{
    public JLabel result;

    public OtherThread(JLabel result) {
        this.result = result;
    }

    @Override
    public void run() {

        int[] numbersArray= new int[100000000];

        ArrayFiller filler = new ArrayFiller();
        filler.randomFill(numbersArray);


        ThreadPool calculatorPool= new ThreadPool((port) -> {
            long sum=0;
            for (int i = port.leftIndex; i < port.rightIndex; i++) {
                sum+=port.array[i];
            }
            port.output=sum;
        });

        Future<Long> firstThreadOutput = calculatorPool.arraySum(new ThreadPool.IO_Port(numbersArray,0,numbersArray.length/2));
        Future<Long> secondThreadOutput =  calculatorPool.arraySum(new ThreadPool.IO_Port(numbersArray,numbersArray.length/2,numbersArray.length));
        try {
            long output = getFutureSum(firstThreadOutput,secondThreadOutput);
            result.setText(output+"");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static long getFutureSum(Future<Long> firstFuture, Future<Long> secondFuture) throws ExecutionException, InterruptedException {
        long firstResult = firstFuture.get();
        long secondResult = secondFuture.get();

        return firstResult+secondResult;
    }

}
