package com.smartcity.traffic;

public abstract class Vehicle {
    protected String lane;
    protected boolean passed;

    public Vehicle(String lane) {
        this.lane = lane;
        this.passed = false;
    }

    public abstract void move(String currentLane, String signal);
}
