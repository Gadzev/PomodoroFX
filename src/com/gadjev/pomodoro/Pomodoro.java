package com.gadjev.pomodoro;

public class Pomodoro {

    private int minutes;
    private boolean active = false;

    public Pomodoro(int mins) {
        this.minutes = mins;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void ring() {
        active = false;
    }
}
