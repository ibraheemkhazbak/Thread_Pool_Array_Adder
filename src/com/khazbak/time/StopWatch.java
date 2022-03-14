package com.khazbak.time;

public class StopWatch {
    private long startTime;
    private long endTime;
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    public void reset(){
        startTime = 0;
        endTime = 0;
    }
    public double getTimeInSeconds(){
        double timeInMillis = getTime();
        return timeInMillis/1000;
    }

    private long getTime() {
    return endTime-startTime;
    }
}
