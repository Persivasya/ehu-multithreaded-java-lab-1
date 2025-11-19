package com.example.taskeight;

public class CounterMain {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Toggler toggler = new Toggler(counter);
        Thread togglerThread = new Thread(toggler, "TogglerThread");
        Thread counterThread = new Thread(counter, "CounterThread");
        togglerThread.start();
        counterThread.start();
        try {
            togglerThread.join();
            counterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished");
    }
}
