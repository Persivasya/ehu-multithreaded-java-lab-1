package com.example.taskseven;

public class YieldMain {

    private static final int THREAD_COUNT = 8;
    private static final long ITERATIONS = 50_000_000L;

    public static void main(String[] args) throws InterruptedException {
        Runnable taskWithYield = () -> {
            long x = 0;
            for (long i = 0; i < ITERATIONS; i++) {
                x += i;
                Thread.yield();
            }
            // Prevent JIT from optimizing away the loop
            if (x == 42) {
                System.out.println("Impossible: " + x);
            }
        };

        Runnable taskWithoutYield = () -> {
            long x = 0;
            for (long i = 0; i < ITERATIONS; i++) {
                x += i;
            }
            // Prevent JIT from optimizing away the loop
            if (x == 42) {
                System.out.println("Impossible: " + x);
            }
        };

        // Warm up
        test(taskWithYield);
        test(taskWithoutYield);

        System.out.println("=== Actual measurement ===");
        long noYieldTime = test(taskWithoutYield);
        long yieldTime = test(taskWithYield);

        System.out.println("No yield: " + noYieldTime + " ms");
        System.out.println("With yield: " + yieldTime + " ms");
    }

    private static long test(Runnable task) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];

        long start = System.currentTimeMillis();

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        return duration;
    }
}
