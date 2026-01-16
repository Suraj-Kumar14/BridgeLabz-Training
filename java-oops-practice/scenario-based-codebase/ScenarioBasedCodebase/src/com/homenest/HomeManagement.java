package com.homenest;

public class HomeManagement {
	private User user;

	public HomeManagement(User user) {
		this.user = user;
	}
	
   public void turnOnDevice(Device device) {
        if (device instanceof IControllable) {
            System.out.println("\n"+user.getName() + " is turning ON the device");
            ((IControllable) device).turnOn();
        }
    }

    public void turnOffDevice(Device device) {
        if (device instanceof IControllable) {
            System.out.println("\n"+user.getName() + " is turning OFF the device");
            ((IControllable) device).turnOff();
        }
    }

    public void resetDevice(Device device) {
        if (device instanceof IControllable) {
            System.out.println("\n"+user.getName() + " is resetting the device");
            ((IControllable) device).reset();
        }
    }
}

