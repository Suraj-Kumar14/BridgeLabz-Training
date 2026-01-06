package com.EventEase;
import java.util.List;

public abstract class Event implements ISchedulable {

    private static int counter = 1000;
    private final int eventId; // cannot be modified once assigned

    protected String eventName;
    protected String location;
    protected String date;
    protected List<String> attendees;

    // Packages
    protected boolean catering;
    protected boolean decoration;

    private double venueCost;      
    private double serviceCost;    
    private double discount;       

    // Constructor without packages
    public Event(String eventName, String location, String date, List<String> attendees, double venueCost) {
        this.eventId = counter++;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.venueCost = venueCost;
        this.serviceCost = 0;
        this.discount = 0;
        this.catering = false;
        this.decoration = false;
    }

    // Constructor with packages
    public Event(String eventName, String location, String date, List<String> attendees,
                 double venueCost, boolean catering, boolean decoration) {
        this(eventName, location, date, attendees, venueCost);
        this.catering = catering;
        this.decoration = decoration;
        calculateServiceCost();
    }

    private void calculateServiceCost() {
        serviceCost = 0;
        if (catering) serviceCost += 5000;
        if (decoration) serviceCost += 3000;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Operator alternative: total cost
    public double getTotalCost() {
        return venueCost + serviceCost - discount;
    }

    public int getEventId() {
        return eventId;
    }

    public abstract void schedule(); 

    @Override
    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println(eventName + " rescheduled to " + newDate);
    }

    @Override
    public void cancel() {
        System.out.println(eventName + " has been canceled.");
    }
}
