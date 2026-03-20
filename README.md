# Smart City Traffic Simulator - OOPS Project

A comprehensive Java Swing application demonstrating Object-Oriented Programming principles through a dynamic traffic management system.

## 📋 Project Overview

This project simulates a smart city traffic intersection with intelligent signal management, vehicle movement, and emergency handling.

## 👥 Team Members & Contributions

- **Arjun**: Vehicle Hierarchy & Polymorphism
  - Abstract `Vehicle` class
  - `PrivateCar`, `PublicBus`, and `Ambulance` subclasses
  - Polymorphic `move()` method implementation

- **Abhinav**: Circular Smart Traffic Logic
  - 4-way intersection management
  - Fixed 80-second cycle implementation
  - Smart redistribution algorithm
  - Emergency override system

- **Anupam**: GUI & Interactivity
  - Java Swing interface
  - Real-time intersection visualization
  - Interactive control buttons
  - Timer displays

## 🎯 Key Features

### 1. Vehicle Hierarchy (OOPS Principles)
- **Abstract Vehicle Class**: Base class with common properties (x, y, speed, color, laneID)
- **Polymorphism**: Each vehicle type implements its own `move()` method
- **Inheritance**: PrivateCar, PublicBus, and Ambulance extend Vehicle
- **Encapsulation**: Protected fields with public getters/setters

### 2. Circular Smart Logic
- **Fixed Cycle**: Total cycle time is always exactly 80 seconds
- **Circular Rotation**: Signals change in sequence: North → East → South → West → North
- **Modulo Operator**: Uses `%` for seamless circular loop
- **Smart Redistribution**: When a lane is empty, remaining green time transfers to next lane
- **Emergency Override**: Ambulance detection shortens current green light to 3 seconds

### 3. Interactive GUI
- **4-Way Intersection**: Visual representation of roads and traffic lights
- **Real-time Timers**: 
  - Current light countdown
  - Master cycle timer (0-80 seconds)
- **Control Buttons**:
  - Spawn Heavy Traffic (for each lane)
  - Spawn Ambulance
  - Toggle Smart Mode
- **Visual Feedback**: Traffic lights change color, vehicles move smoothly

## 🏗️ Project Structure

```
JAVAProj/
└── src/
    └── com/
        └── smartcity/
            └── traffic/
                ├── Vehicle.java           (Abstract base class)
                ├── PrivateCar.java        (Concrete vehicle)
                ├── PublicBus.java         (Concrete vehicle)
                ├── Ambulance.java         (Emergency vehicle)
                ├── TrafficLight.java      (Signal management)
                ├── TrafficController.java (Smart logic controller)
                ├── TrafficSimulatorGUI.java (Main GUI)
                └── Main.java              (Application entry point)
```

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java Swing (included in JDK)

### Compilation
```bash
cd "Documents/Developer's Drive/JAVAProj/src"
javac com/smartcity/traffic/*.java
```

### Execution
```bash
java com.smartcity.traffic.Main
```

## 🎮 How to Use

1. **Launch Application**: Run the Main class
2. **Observe Traffic**: Watch vehicles move and stop based on signals
3. **Spawn Traffic**: Click "Heavy Traffic" buttons to add 5-8 vehicles to a specific lane
4. **Emergency Test**: Click "Spawn Ambulance" to trigger emergency override
5. **Toggle Smart Mode**: Enable/disable smart redistribution
6. **Watch Timers**: 
   - Top timer shows current green light and remaining time
   - Middle timer shows total cycle progress (0-80s)

## 🔧 Technical Implementation

### OOPS Concepts Demonstrated

1. **Abstraction**
   - Abstract `Vehicle` class defines interface
   - Subclasses provide concrete implementations

2. **Inheritance**
   - All vehicle types extend `Vehicle`
   - Code reuse through inheritance

3. **Polymorphism**
   - `move()` method behaves differently for each vehicle type
   - ArrayList<Vehicle> holds different vehicle types

4. **Encapsulation**
   - Private/protected fields
   - Public getter/setter methods
   - Information hiding

### Smart Logic Details

```java
// Circular rotation using modulo
currentLaneIndex = (currentLaneIndex + 1) % 4;

// Fixed 80-second cycle enforcement
if (cycleTimeElapsed >= TOTAL_CYCLE_TIME) {
    cycleTimeElapsed = 0;
}

// Smart redistribution
if (laneIsEmpty && timeRemaining > 5) {
    nextLaneTime += timeRemaining;
    currentLaneTime = 0;
}

// Emergency override
if (ambulanceDetected && notInCurrentLane) {
    currentLaneTime = Math.min(currentLaneTime, 3);
}
```

## 📊 Traffic Rules

- **Private Cars**: Speed 3, Blue color, Stop at red lights
- **Public Buses**: Speed 2, Orange color, Stop at red lights, Larger size
- **Ambulances**: Speed 4, Red color, Trigger emergency override
- **Default Green Time**: 20 seconds per lane (80/4)
- **Yellow Time**: 3 seconds (transition period)

## 🎨 GUI Components

- **Intersection Panel**: 600x600 pixels
- **Control Panel**: 250 pixels wide
- **Traffic Lights**: 4 signals (N, E, S, W)
- **Vehicle Legend**: Color-coded vehicle types
- **Real-time Animation**: Updates every 100ms
- **Signal Updates**: Every 1 second

## 🧪 Testing Scenarios

1. **Normal Operation**: Observe regular 20-second green lights
2. **Smart Redistribution**: Spawn traffic on one lane, watch others get reduced time
3. **Emergency Override**: Spawn ambulance, see immediate signal response
4. **Heavy Traffic**: Test all lanes with heavy traffic simultaneously
5. **Smart Mode Toggle**: Compare behavior with smart mode on/off

## 🏆 Learning Outcomes

- Understanding of OOPS principles (Abstraction, Inheritance, Polymorphism, Encapsulation)
- Java Swing GUI development
- Event-driven programming with Timers
- ArrayList management
- Circular logic implementation with modulo operator
- Real-time system simulation
- Smart algorithm design

## 📝 Notes

- All vehicles automatically removed when they pass the intersection
- Ambulances can slow down at red lights but don't stop completely
- Smart mode can be toggled on/off during runtime
- Traffic signals always complete full 80-second cycles
- Console output shows smart redistribution and emergency override events

## 🔮 Future Enhancements (Optional)

- Add pedestrian crossings
- Implement traffic density metrics
- Add sound effects for ambulances
- Create traffic jam detection
- Add night mode with different timings
- Implement weather conditions
- Add statistics dashboard

---

**Project Date**: February 8, 2026  
**Java Version**: Compatible with JDK 8+  
**Framework**: Java Swing  
**License**: Educational Project
