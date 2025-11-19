package com.example.taskone;

public class ThreadsMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1 is running");
            }
        });
        thread1.start();
        thread1.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread is running");
        }
    }
}
