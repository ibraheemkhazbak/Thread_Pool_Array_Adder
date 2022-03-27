package com.khazbak.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class ThreadPool {
    ExecutorService executor= Executors.newCachedThreadPool();
    Consumer<IO_Port> consumer;

    public ThreadPool(Consumer<IO_Port> consumer) {
        this.consumer = consumer;
    }

    public Future<Long> arraySum(IO_Port port){
        return executor.submit(() -> {
            consumer.accept(port);

            return port.output;
        });
    }
    static class IO_Port {
        public int[] array;
        public int leftIndex, rightIndex;
        public long output;

        public IO_Port(int[] array, int leftIndex, int rightIndex) {
            this.array = array;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

    }
}
