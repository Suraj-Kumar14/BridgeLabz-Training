package com.parceltracker;

class ParcelTracker {
    private Stage head;   

    // Add stage at the end
    public void addStage(String stageName) {
        Stage newStage = new Stage(stageName);
        if (head == null) {
            head = newStage;
        } else {
            Stage temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStage;
        }
    }

    // Insert custom checkpoint after a given stage
    public void insertCheckpoint(String afterStage, String newStageName) {
        Stage temp = head;
        while (temp != null && !temp.name.equals(afterStage)) {
            temp = temp.next;
        }
        if (temp != null) {
            Stage newStage = new Stage(newStageName);
            newStage.next = temp.next;
            temp.next = newStage;
        } else {
            System.out.println("Stage '" + afterStage + "' not found!");
        }
    }

    // Forward tracking
    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel is missing!");
            return;
        }
        Stage temp = head;
        while (temp != null) {
            System.out.print(temp.name + " → ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Check if parcel is lost
    public boolean isParcelLost() {
        return head == null;
    }
}