package com.example.taskeight;

import java.util.Random;

public class Toggler implements Runnable {

    private volatile boolean state = false;
    private final StateListener listener;

    public Toggler(StateListener listener) {
        this.listener = listener;
    }

    private void setState(boolean newState) {
        this.state = newState;
        listener.onStateChange(newState);
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (!listener.isFinished()) {
                boolean newState = !state;
                setState(newState);
                System.out.println("Toggler state = " + newState);

                int sleepSeconds = random.nextInt(1, 6);
                Thread.sleep(sleepSeconds * 1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Toggler finished");
    }
}
