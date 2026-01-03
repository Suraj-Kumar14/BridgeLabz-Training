package com.SmartHomeAutomationSystem;

class Fan extends Appliance {
    public Fan(String name, int powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " fan is ON. Speed set to medium.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " fan is OFF.");
    }
}

