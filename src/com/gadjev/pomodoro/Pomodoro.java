package com.gadjev.pomodoro;

public class Pomodoro {

    private int minutes;
    private boolean active;

    public Pomodoro(int mins) {
        this.minutes = mins;
        active = true;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isActive() {
        return active;
    }

    public void ring() {
        active = false;
    }
}
