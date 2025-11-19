package com.example.taskfive;

public class InterruptedMain {

    public static void main(String[] args) {
        Thread th = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
            }
        });
        th.start();
        th.interrupt();
    }
}
