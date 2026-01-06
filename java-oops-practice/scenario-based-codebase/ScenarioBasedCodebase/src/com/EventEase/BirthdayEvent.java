package com.EventEase;

import java.util.List;

public class BirthdayEvent extends Event {

    public BirthdayEvent(String eventName, String location, String date, List<String> attendees, double venueCost,
                         boolean catering, boolean decoration) {
        super(eventName, location, date, attendees, venueCost, catering, decoration);
    }

    @Override
    public void schedule() {
        System.out.println("Birthday Event '" + eventName + "' scheduled on " + date +
                " at " + location + " with fun activities for attendees.");
    }
}
