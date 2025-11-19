package com.example.taskeight;

public class Counter implements Runnable, StateListener {

    private volatile boolean state = false;
    private int counter = 50;
    private boolean finished = false;

    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public void onStateChange(boolean newState) {
        this.state = newState;
    }

    @Override
    public void run() {
        try {
            while (counter >= 0 && !Thread.currentThread().isInterrupted()) {
                if (state) {
                    System.out.println("Counter " + counter);
                    counter--;
                } else {
                    System.out.println("Counter paused at " + counter);
                }
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Counter done");
        finished = true;
    }
}
