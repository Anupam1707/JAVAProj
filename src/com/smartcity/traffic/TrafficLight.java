package com.smartcity.traffic;

public class TrafficLight {
    public String direction;
    public String state;

    public TrafficLight(String direction) {
        this.direction = direction;
        this.state = "RED";
    }

    public void setState(String state) {
        this.state = state;
    }
}
