package com.khazbak;

import com.khazbak.array.ArrayFiller;
import com.khazbak.display.Window;
import com.khazbak.thread.ThreadPool;
import com.khazbak.time.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main{
    static ExecutorService executor = Executors.newCachedThreadPool();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Window();




    }


   }
