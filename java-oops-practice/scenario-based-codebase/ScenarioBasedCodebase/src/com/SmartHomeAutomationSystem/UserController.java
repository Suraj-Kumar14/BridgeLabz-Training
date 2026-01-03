package com.SmartHomeAutomationSystem;

class UserController {
    public void controlDevice(Appliance appliance, boolean turnOn) {
        if(turnOn) {
            appliance.turnOn();
        } else {
            appliance.turnOff();
        }
    }

    public void compareEnergy(Appliance a1, Appliance a2) {
        if(a1.consumesMoreThan(a2)) {
            System.out.println(a1.getName() + " consumes more energy than " + a2.getName());
        } else if(a1.consumesLessThan(a2)) {
            System.out.println(a1.getName() + " consumes less energy than " + a2.getName());
        } else {
            System.out.println(a1.getName() + " consumes equal energy as " + a2.getName());
        }
    }
}
