package com.SmartHomeAutomationSystem;

public class SmartHome {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room", 60);
        Fan ceilingFan = new Fan("Ceiling Fan", 75);
        AC bedroomAC = new AC("Bedroom AC", 1500);

        UserController controller = new UserController();

        controller.controlDevice(livingRoomLight, true);
        controller.controlDevice(ceilingFan, true);
        controller.controlDevice(bedroomAC, true);

        controller.compareEnergy(livingRoomLight, bedroomAC);
        controller.compareEnergy(ceilingFan, livingRoomLight);
    }
}
