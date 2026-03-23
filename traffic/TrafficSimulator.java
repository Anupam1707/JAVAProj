package com.smartcity.traffic;

import java.util.ArrayList;
import java.util.Scanner;

public class TrafficSimulator {
    private TrafficLight[] lights;
    private ArrayList<Vehicle> vehicles;
    private int currentLight;
    private int cycleTime;
    private boolean ambulancePresent;
    private int carsPassed;
    private int ambulancesPassed;

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
        carsPassed = 0;
        ambulancesPassed = 0;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Smart Traffic Simulator (Simplified)");
        System.out.println("Commands: addcar, addambulance, exit");

        Thread tickThread = new Thread(() -> {
            while (true) {
                tick();
                try {
                    Thread.sleep(1000); // 1 second interval
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        tickThread.setDaemon(true);
        tickThread.start();

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
            } else if (cmd.equals("exit")) {
                tickThread.interrupt();
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
            // Emergency countdown handled in GUI
            if (cycleTime >= 3) {
                ambulancePresent = false;
                cycleTime = 0;
                nextLight();
            }
        } else {
            for (int i = 0; i < lights.length; i++) {
                lights[i].setState(i == currentLight ? "GREEN" : "RED");
            }
            // Normal countdown handled in GUI
            if (cycleTime >= 20) {
                cycleTime = 0;
                nextLight();
            }
        }
        for (Vehicle v : vehicles) {
            boolean wasPassed = v.passed;
            v.move(lights[currentLight].direction, lights[currentLight].state);
            if (!wasPassed && v.passed) {
                if (v instanceof Car) carsPassed++;
                if (v instanceof Ambulance) ambulancesPassed++;
            }
        }
    }

    // GUI metric methods (add getCountdown)
    public int getCountdown() {
        return ambulancePresent ? (3 - cycleTime) : (20 - cycleTime);
    }

    // GUI metric methods
    public String getCurrentLane() {
        return lights[currentLight].direction;
    }
    public int getCarCount() {
        int count = 0;
        for (Vehicle v : vehicles) if (v instanceof Car && !v.passed) count++;
        return count;
    }
    public int getAmbulanceCount() {
        int count = 0;
        for (Vehicle v : vehicles) if (v instanceof Ambulance && !v.passed) count++;
        return count;
    }
    public int getCarsPassed() {
        return carsPassed;
    }
    public int getAmbulancesPassed() {
        return ambulancesPassed;
    }
    public boolean isEmergency() {
        return ambulancePresent;
    }

    private void nextLight() {
        currentLight = (currentLight + 1) % lights.length;
    }
}
