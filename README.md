
# Smart City Traffic Simulator

A Java Swing desktop simulator for a smart 4-way intersection with adaptive signals, emergency preemption, and live traffic stats.

## Overview

This project models city traffic behavior using object-oriented design. It is focused on clean class structure and practical simulation behavior rather than heavy external dependencies.

## Key Features

- Java Swing GUI simulation
- 4-way intersection (North, East, South, West)
- Vehicle types: Private Car, Public Bus, Motorcycle, Ambulance
- Emergency override for ambulances
- Smart mode for adaptive signal timing
- Real-time lane and queue statistics
- Custom exception handling
- Clear package-based source organization

## OOP Concepts Demonstrated

- Encapsulation via private/protected fields and validation
- Inheritance across vehicle subclasses
- Polymorphism with base-class references and overridden behavior
- Interface usage through `EmergencyVehicle`
- Abstract base class usage through `Vehicle`
- Constructor and method overloading
- Collections (`ArrayList`, `HashMap`) in controller/simulation logic
- User-defined exception (`InvalidVehicleDataException`)

## Project Structure

```text
JAVAProj/
|-- src/
|   `-- com/smartcity/traffic/
|       |-- Main.java
|       |-- TrafficSimulatorGUI.java
|       |-- TrafficController.java
|       |-- TrafficLight.java
|       |-- Vehicle.java
|       |-- PrivateCar.java
|       |-- PublicBus.java
|       |-- Motorcycle.java
|       |-- Ambulance.java
|       |-- EmergencyVehicle.java
|       `-- util/InvalidVehicleDataException.java
|-- docs/
|   `-- index.html
|-- report.tex
|-- Requirement_Mapping.md
`-- README.md
```

## Run From Source

### Prerequisites

- JDK 8 or newer

### Compile

Run from repository root:

```bash
cd src
javac com/smartcity/traffic/*.java com/smartcity/traffic/util/*.java
```

### Start

```bash
cd src
java com.smartcity.traffic.Main
```

## Downloads and Releases

- Latest builds are published on GitHub Releases:
   https://github.com/Anupam1707/JAVAProj/releases
- Landing page for downloads:
   https://anupam1707.github.io/JAVAProj/
- If no latest release is available, the downloads page falls back to source archives so users can still download the project.

## Usage

1. Launch the app.
2. Spawn vehicles and observe traffic flow.
3. Toggle smart mode to adapt signal timing.
4. Add ambulances to trigger emergency priority.
5. Pause/resume and adjust speed as needed.

## Documentation

- Source-level OOP implementation: see `src/com/smartcity/traffic`
- Mapping and report: `Requirement_Mapping.md`, `report.tex`

## Future Enhancements

- Persistent save/load of simulation state
- Additional vehicle behaviors
- Richer analytics and dashboards
- More advanced adaptive signal heuristics

---

Project date: April 2026  
Java compatibility: JDK 8+  
License: Educational project
