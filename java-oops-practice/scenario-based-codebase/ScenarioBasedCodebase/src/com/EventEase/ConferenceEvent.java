package com.EventEase;

import java.util.List;

public class ConferenceEvent extends Event {

    public ConferenceEvent(String eventName, String location, String date, List<String> attendees, double venueCost,
                           boolean catering, boolean decoration) {
        super(eventName, location, date, attendees, venueCost, catering, decoration);
    }

    @Override
    public void schedule() {
        System.out.println("Conference Event '" + eventName + "' scheduled on " + date +
                " at " + location + " for professional meetings.");
    }
}
