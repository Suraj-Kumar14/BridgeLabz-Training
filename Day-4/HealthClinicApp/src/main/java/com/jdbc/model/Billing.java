package com.jdbc.model;

public class Billing {

    private int billId;
    private int visitId;
    private double amount;
    private String paymentStatus;

    public Billing() {
    }

    public Billing(int visitId, double amount, String paymentStatus) {
        this.visitId = visitId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Billing [billId=" + billId
                + ", visitId=" + visitId
                + ", amount=" + amount
                + ", paymentStatus=" + paymentStatus + "]";
    }
}