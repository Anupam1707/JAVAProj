package com.smartcity.traffic;

import java.awt.Color;

/**
 * Abstract base class for all vehicles in the traffic simulator.
 * Implements OOPS principles with encapsulation and abstraction.
 *
 * @author Arjun
 */
public abstract class Vehicle {
    // Protected fields for subclass access
    protected int x;
    protected int y;
    protected int speed;
    protected Color color;
    protected String laneID; // "NORTH", "EAST", "SOUTH", "WEST"
    protected boolean isMoving;

    // Intersection boundaries (center square where vehicles must not stop)
    protected static final int INTERSECTION_CENTER_X = 375; // Center of 750px panel
    protected static final int INTERSECTION_CENTER_Y = 375;
    protected static final int INTERSECTION_HALF_WIDTH = 70; // Half of road width

    /**
     * Constructor for Vehicle
     * @param x      Initial x-coordinate
     * @param y      Initial y-coordinate
     * @param speed  Speed of the vehicle
     * @param color  Color of the vehicle
     * @param laneID Lane identifier (NORTH, EAST, SOUTH, WEST)
     */
    public Vehicle(int x, int y, int speed, Color color, String laneID) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
        this.laneID = laneID;
        this.isMoving = true;
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Uses polymorphism – each vehicle type has its own movement behaviour.
     * @param signalState The current traffic signal state for this vehicle's lane
     */
    public abstract void move(String signalState);

    /**
     * Shared helper: move this vehicle one step in its lane direction at the given speed.
     * Eliminates the repeated switch(laneID) blocks in every subclass.
     * @param spd pixels to move this tick
     */
    protected void moveInLaneDirection(int spd) {
        switch (laneID) {
            case "NORTH": y -= spd; break;
            case "SOUTH": y += spd; break;
            case "EAST":  x += spd; break;
            case "WEST":  x -= spd; break;
        }
    }

    /**
     * Check if vehicle is currently inside the intersection square.
     * @return true if inside intersection, false otherwise
     */
    protected boolean isInIntersection() {
        return x >= (INTERSECTION_CENTER_X - INTERSECTION_HALF_WIDTH) &&
               x <= (INTERSECTION_CENTER_X + INTERSECTION_HALF_WIDTH) &&
               y >= (INTERSECTION_CENTER_Y - INTERSECTION_HALF_WIDTH) &&
               y <= (INTERSECTION_CENTER_Y + INTERSECTION_HALF_WIDTH);
    }

    /**
     * Check if vehicle is approaching the intersection (close to it).
     * @return true if approaching intersection, false otherwise
     */
    protected boolean isApproachingIntersection() {
        int approachDistance = 100; // Distance from intersection to start checking signal

        switch (laneID) {
            case "NORTH":
                return y > (INTERSECTION_CENTER_Y + INTERSECTION_HALF_WIDTH) &&
                       y < (INTERSECTION_CENTER_Y + INTERSECTION_HALF_WIDTH + approachDistance);
            case "SOUTH":
                return y < (INTERSECTION_CENTER_Y - INTERSECTION_HALF_WIDTH) &&
                       y > (INTERSECTION_CENTER_Y - INTERSECTION_HALF_WIDTH - approachDistance);
            case "EAST":
                return x < (INTERSECTION_CENTER_X - INTERSECTION_HALF_WIDTH) &&
                       x > (INTERSECTION_CENTER_X - INTERSECTION_HALF_WIDTH - approachDistance);
            case "WEST":
                return x > (INTERSECTION_CENTER_X + INTERSECTION_HALF_WIDTH) &&
                       x < (INTERSECTION_CENTER_X + INTERSECTION_HALF_WIDTH + approachDistance);
            default:
                return false;
        }
    }

    /**
     * Check if vehicle should stop based on traffic signal.
     * Vehicles stop only if:
     *   1. Signal is RED
     *   2. They are approaching (not already in) the intersection
     * @param signalState Current signal state ("GREEN", "RED", "YELLOW")
     * @return true if vehicle should stop, false otherwise
     */
    protected boolean shouldStop(String signalState) {
        // Never stop if already in the intersection – must clear it!
        if (isInIntersection()) {
            return false;
        }
        // Only stop at red if approaching the intersection
        return "RED".equals(signalState) && isApproachingIntersection();
    }

    // ── Getters and Setters ──────────────────────────────────────────────────

    public int getX()          { return x; }
    public int getY()          { return y; }
    public Color getColor()    { return color; }
    public String getLaneID()  { return laneID; }
    public int getSpeed()      { return speed; }
    public boolean isMoving()  { return isMoving; }

    public void setMoving(boolean moving) { this.isMoving = moving; }

    /**
     * Check if vehicle has exited the visible simulation area.
     * Boundaries match the 750×750 intersection panel with a small margin.
     * @return true if vehicle has left the visible area
     */
    public boolean hasPassedIntersection() {
        return x > 800 || x < -100 || y > 800 || y < -100;
    }

    /**
     * Get the type of vehicle as a human-readable string.
     * @return Vehicle type name
     */
    public abstract String getVehicleType();
}
