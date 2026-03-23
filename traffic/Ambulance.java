package com.smartcity.traffic;

public class Ambulance extends Vehicle {
    public Ambulance(String lane) {
        super(lane);
    }

    @Override
    public void move(String currentLane, String signal) {
        if (!passed && lane.equals(currentLane)) {
            passed = true;
            System.out.println("Ambulance in lane " + lane + " passed intersection (priority).");
        }
    }
}
