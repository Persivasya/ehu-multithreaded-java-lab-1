package com.example.tasktwo;

public class ThreadWithRunnableMain {

    public static void main(String[] args) {
        Thread thread1 = new MyThread(new MyRunnable());
        thread1.start();
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable is running");
            }
        }
    }

    private static class MyThread extends Thread {

        public MyThread(Runnable runnable) {
            super(runnable);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread is running");
            }
        }
    }
}
