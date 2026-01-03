package com.SmartHomeAutomationSystem;

abstract class Appliance implements Controllable {
    private String name;
    private int powerUsage;   
    private boolean isOn;

    // Constructor
    public Appliance(String name, int powerUsage) {
        this.name = name;
        this.powerUsage = powerUsage;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public int getPowerUsage() {
        return powerUsage;
    }

    public boolean isOn() {
        return isOn;
    }

    // Encapsulation
    protected void setOn(boolean state) {
        this.isOn = state;
    }

    // Operator usage
    public boolean consumesMoreThan(Appliance other) {
        return this.powerUsage > other.powerUsage;
    }
    
    public boolean consumesLessThan(Appliance other) {
        return this.powerUsage < other.powerUsage;
    }

    public boolean consumesEqualTo(Appliance other) {
        return this.powerUsage == other.powerUsage;
    }
}

