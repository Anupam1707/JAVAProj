package com.smartcity.traffic;

import java.util.ArrayList;
import java.util.Scanner;

public class TrafficSimulator {
    private TrafficLight[] lights;
    private ArrayList<Vehicle> vehicles;
    private int currentLight;
    private int cycleTime;
    private boolean ambulancePresent;

    public TrafficSimulator() {
        lights = new TrafficLight[] {
            new TrafficLight("NORTH"),
            new TrafficLight("EAST"),
            new TrafficLight("SOUTH"),
            new TrafficLight("WEST")
        };
        vehicles = new ArrayList<>();
        currentLight = 0;
        cycleTime = 0;
        ambulancePresent = false;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Smart Traffic Simulator (Simplified)");
        System.out.println("Commands: addcar, addambulance, tick, exit");
        while (true) {
            System.out.print("Enter command: ");
            String cmd = sc.nextLine();
            if (cmd.equals("addcar")) {
                vehicles.add(new Car(lights[currentLight].direction));
                System.out.println("Car added.");
            } else if (cmd.equals("addambulance")) {
                vehicles.add(new Ambulance(lights[currentLight].direction));
                ambulancePresent = true;
                System.out.println("Ambulance added.");
            } else if (cmd.equals("tick")) {
                tick();
            } else if (cmd.equals("exit")) {
                break;
            }
        }
        sc.close();
    }

    private void tick() {
        cycleTime++;
        // Emergency override: if ambulance present, green for its lane only
        if (ambulancePresent) {
            for (int i = 0; i < lights.length; i++) {
                lights[i].setState(i == currentLight ? "GREEN" : "RED");
            }
            System.out.println("Emergency! Ambulance lane green for 3 seconds.");
            if (cycleTime >= 3) {
                ambulancePresent = false;
                cycleTime = 0;
                nextLight();
            }
        } else {
            for (int i = 0; i < lights.length; i++) {
                lights[i].setState(i == currentLight ? "GREEN" : "RED");
            }
            System.out.println("Normal cycle. Lane " + lights[currentLight].direction + " is GREEN.");
            if (cycleTime >= 20) {
                cycleTime = 0;
                nextLight();
            }
        }
        for (Vehicle v : vehicles) {
            v.move(lights[currentLight].direction, lights[currentLight].state);
        }
    }

    private void nextLight() {
        currentLight = (currentLight + 1) % lights.length;
    }
}
