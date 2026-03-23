package com.smartcity.traffic;

public class Main {
    public static void main(String[] args) {
        TrafficSimulator simulator = new TrafficSimulator();
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TrafficSimulatorGUI(simulator);
        });
        simulator.run();
    }
}
