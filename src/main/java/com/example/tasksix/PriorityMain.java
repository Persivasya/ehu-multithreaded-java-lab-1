package com.example.tasksix;

import java.util.ArrayList;
import java.util.List;

public class PriorityMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Testing max priority");
        testMaxPriority();
        System.out.println("\n");
        System.out.println("Testing min priority");
        testMinPriority();
    }

    private static void testMaxPriority() throws InterruptedException {
        Thread test = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Priority is MAX");
            }
        });
        test.setPriority(Thread.MAX_PRIORITY);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(
                new Thread(() -> {
                    for (int j = 0; j < 100; j++) {
                        System.out.print("|");
                    }
                })
            );
        }
        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        test.start();
        test.join();
        long end = System.currentTimeMillis();
        System.out.println("The time is " + (end - start) + " milliseconds");
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static void testMinPriority() throws InterruptedException {
        Thread test = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Priority is MIN");
            }
        });
        test.setPriority(Thread.MIN_PRIORITY);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(
                new Thread(() -> {
                    for (int j = 0; j < 100; j++) {
                        System.out.print("|");
                    }
                })
            );
        }
        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        test.start();
        test.join();
        long end = System.currentTimeMillis();
        System.out.println("The time is " + (end - start) + " milliseconds");
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
