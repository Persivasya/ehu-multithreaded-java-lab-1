package com.example.taskeight;

public interface StateListener {
    void onStateChange(boolean newState);
    boolean isFinished();
}
