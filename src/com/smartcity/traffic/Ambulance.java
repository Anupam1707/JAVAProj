package com.smartcity.traffic;

import java.awt.Color;

/**
 * Ambulance class – represents an emergency ambulance in the traffic system.
 * Ambulances have priority and trigger emergency override in traffic signals.
 * Demonstrates inheritance and polymorphism.
 *
 * @author Arjun
 */
public class Ambulance extends Vehicle {
    private boolean emergencyMode;

    /**
     * Constructor for Ambulance
     * @param x      Initial x-coordinate
     * @param y      Initial y-coordinate
     * @param laneID Lane identifier
     */
    public Ambulance(int x, int y, String laneID) {
        super(x, y, 4, Color.RED, laneID); // Speed: 4 (fastest), Red colour
        this.emergencyMode = true;
    }

    /**
     * Polymorphic implementation of move() for Ambulance.
     * Ambulances always clear the intersection if inside.
     * At a red light they slow down but never fully stop (emergency mode).
     * @param signalState Current traffic signal state
     */
    @Override
    public void move(String signalState) {
        // If already in intersection, always clear it at full speed
        if (isInIntersection()) {
            isMoving = true;
            moveInLaneDirection(speed);
            return;
        }

        // Not in intersection – check if approaching a red light
        boolean approachingRed = "RED".equals(signalState) && isApproachingIntersection();

        if (approachingRed && emergencyMode) {
            // Ambulances slow to half speed at red but never stop
            isMoving = true;
            moveInLaneDirection(speed / 2);
        } else if (approachingRed) {
            // Emergency mode off – behave like a normal vehicle
            isMoving = false;
        } else {
            // Green or yellow – move at full speed
            isMoving = true;
            moveInLaneDirection(speed);
        }
    }

    public boolean isEmergencyMode() { return emergencyMode; }
    public void setEmergencyMode(boolean emergencyMode) { this.emergencyMode = emergencyMode; }

    @Override
    public String getVehicleType() { return "Ambulance"; }
}
