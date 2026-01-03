package com.SmartHomeAutomationSystem;

class Light extends Appliance {
    public Light(String name, int powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " light is ON. Brightness set.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " light is OFF.");
    }
}
