package com.smartcity.traffic;

public class Car extends Vehicle {
    public Car(String lane) {
        super(lane);
    }

    @Override
    public void move(String currentLane, String signal) {
        if (!passed && lane.equals(currentLane) && signal.equals("GREEN")) {
            passed = true;
            System.out.println("Car in lane " + lane + " passed intersection.");
        }
    }
}
