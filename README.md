
# Smart City Traffic Simulator (Simplified)

A minimal Java console application demonstrating smart traffic control logic and OOPS principles.

## Project Overview

This version simulates a smart city intersection with basic signal management and vehicle movement, focusing on clarity and ease of implementation.

## Features

- Console-based simulation (no GUI)
- Fixed 4-way intersection (North, East, South, West)
- Simple vehicle types: Car and Ambulance
- Emergency override: Ambulance gets priority green signal
- Minimal code structure for easy understanding

## Project Structure

```
JAVAProj/
└── src/
    └── com/
        └── smartcity/
            └── traffic/
                ├── Main.java           (Application entry point)
                ├── TrafficSimulator.java (Simulation logic)
                ├── TrafficLight.java   (Signal management)
                ├── Vehicle.java        (Abstract base class)
                ├── Car.java            (Car vehicle)
                └── Ambulance.java      (Emergency vehicle)
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compilation
```bash
cd "Documents/Developer's Drive/JAVAProj/src"
javac com/smartcity/traffic/Main.java com/smartcity/traffic/TrafficSimulator.java com/smartcity/traffic/TrafficLight.java com/smartcity/traffic/Vehicle.java com/smartcity/traffic/Car.java com/smartcity/traffic/Ambulance.java
```

### Execution
```bash
cd "Documents/Developer's Drive/JAVAProj/src"
java com.smartcity.traffic.Main
```

## Usage

1. Launch the application.
2. Use console commands:
   - `addcar` to add a car
   - `addambulance` to add an ambulance (triggers emergency override)
   - `tick` to advance the simulation by one step
   - `exit` to quit
3. Observe console output for vehicle movement and signal changes.

## Technical Notes

- Demonstrates OOPS principles: abstraction, inheritance, and polymorphism
- Emergency override logic: ambulance lane gets green for 3 seconds
- Minimal code for easy learning and extension

## Future Enhancements
- Add more vehicle types
- Add GUI interface
- Smart redistribution logic
- Statistics and reporting

---
**Project Date**: March 20, 2026  
**Java Version**: Compatible with JDK 8+  
**License**: Educational Project
