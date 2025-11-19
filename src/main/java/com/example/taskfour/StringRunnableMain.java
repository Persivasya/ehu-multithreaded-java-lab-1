package com.example.taskfour;

import java.util.ArrayList;
import java.util.List;

public class StringRunnableMain
{
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new StringRunnable("Hello", "World")));
        threads.add(new Thread(new StringRunnable("Java", "is", "fun")));
        threads.add(new Thread(new StringRunnable("Programming", "is", "easy")));
        threads.add(new Thread(new StringRunnable("I", "love", "Java")));
        threads.add(new Thread(new StringRunnable("Java", "is", "cool")));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static class StringRunnable implements Runnable {
        private String[] str;
        public StringRunnable(String... strings) {
            this.str = strings;
        }
        @Override
        public void run() {
            for (String s : str) {
                System.out.println(s);
            }
        }
    }
}
