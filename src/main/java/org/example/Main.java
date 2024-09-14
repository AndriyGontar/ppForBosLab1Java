package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Main {
    private final static int lenArray = 5000000;
    private final static int[] colsThread = new int[]{1, 2, 3, 4, 8, 16, 32};

    public static void main(String[] args) {
        testThreads();
    }

    private static void testThreads() {
        ThreadSum threadSum = new ThreadSum();
        var arr = threadSum.generateArray(lenArray);
        var startTime = Instant.now();
        long sum = Arrays.stream(arr).asLongStream().sum();
        var stopTime = Instant.now();
        var time = Duration.between(startTime, stopTime);
        System.out.println("Sum array calculated by built-in function is "
                + sum + ". This continues " + time + " milliseconds");
        for (int j : colsThread) {
            startTime = Instant.now();
            sum = threadSum.GetSumArray(arr, j);
            stopTime = Instant.now();
            time = Duration.between(startTime, stopTime);
            System.out.println("Sum with " + j + " threads is " + sum
                    + ". This continues " + time + " milliseconds");
        }
    }
}

