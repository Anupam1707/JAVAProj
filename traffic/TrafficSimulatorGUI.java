package com.smartcity.traffic;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficSimulatorGUI extends JFrame {
    private JLabel laneLabel;
    private JLabel carsLabel;
    private JLabel ambulancesLabel;
    private JLabel emergencyLabel;
    private JLabel countdownLabel;
    private TrafficSimulator simulator;

    public TrafficSimulatorGUI(TrafficSimulator simulator) {
        this.simulator = simulator;
        setTitle("Smart Traffic Metrics");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        laneLabel = new JLabel();
        carsLabel = new JLabel();
        ambulancesLabel = new JLabel();
        emergencyLabel = new JLabel();
        countdownLabel = new JLabel();

        add(laneLabel);
        add(countdownLabel);
        add(carsLabel);
        add(ambulancesLabel);
        add(emergencyLabel);

        setVisible(true);
        startUpdater();
    }

    private void startUpdater() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMetrics();
            }
        }, 0, 1000);
    }

    private void updateMetrics() {
        laneLabel.setText("Current Green Lane: " + simulator.getCurrentLane());
        countdownLabel.setText("Countdown: " + simulator.getCountdown() + "s");
        carsLabel.setText("Cars waiting: " + simulator.getCarCount() + " | Cars passed: " + simulator.getCarsPassed());
        ambulancesLabel.setText("Ambulances waiting: " + simulator.getAmbulanceCount() + " | Ambulances passed: " + simulator.getAmbulancesPassed());
        emergencyLabel.setText("Emergency Active: " + (simulator.isEmergency() ? "YES" : "NO"));
    }
}
