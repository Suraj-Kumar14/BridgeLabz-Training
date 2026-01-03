package com.SmartHomeAutomationSystem;

class AC extends Appliance {
    public AC(String name, int powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " AC is ON. Cooling mode activated.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " AC is OFF.");
    }
}

