package org.example;

import java.util.Random;

public class ThreadSum {
    private long sum;

    public ThreadSum() {
    }

    public int[] generateArray(int lenArray) {
        Random random = new Random();
        int[] array = new int[lenArray];
        for (int i = 0; i < array.length; i++) {
            array[i] =Math.abs(random.nextInt());
        }
        return array;
    }

    private synchronized void addSum(long sumElement) {
        sum += sumElement;
    }

    private Runnable sumElement(int start, int stop, int[] array) {
        long sumElementAraay = 0;
        for (int i = start; i < stop; i++) {
            sumElementAraay += array[i];
        }
        addSum(sumElementAraay);
        return null;
    }

    public long GetSumArray(int[] array, int colThread) {
        sum = 0;
        int len = array.length / colThread;
        for (int i = 0; i < colThread; i++) {
            Thread thread = new Thread(sumElement(len*i,i!=colThread-1?len*(i+1):array.length,array));
            thread.start();
        }
        return sum;
    }
}
