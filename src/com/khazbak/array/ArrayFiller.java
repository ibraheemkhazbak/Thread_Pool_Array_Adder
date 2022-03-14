package com.khazbak.array;

import java.util.Random;

public class ArrayFiller {
        public void randomFill(int[] array){
                Random generator = new Random();
            for (int i = 0 ; i<array.length;i++) {
                array[i]=generator.nextInt(100001);
            }
        }

}
