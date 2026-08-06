package com.jdbc.model;

import java.sql.Timestamp;

public class Visit {

    private int visitId;
    private int appointmentId;
    private Timestamp visitDate;
    private String diagnosis;

    public Visit() {
    }

    public Visit(int appointmentId, Timestamp visitDate, String diagnosis) {
        this.appointmentId = appointmentId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Visit [visitId=" + visitId
                + ", appointmentId=" + appointmentId
                + ", visitDate=" + visitDate
                + ", diagnosis=" + diagnosis + "]";
    }
}