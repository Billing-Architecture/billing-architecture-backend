package com.billing.service.billing_service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillNotificationDTO extends NotificationRequest{

    @JsonProperty("bill_code")
    private String billCode;

    @JsonProperty("bill_total")
    private double billTotal;

    @JsonProperty("bill_total_paid")
    private double billTotalPaid;

    @JsonProperty("bill_to_pay")
    private double billToPay;

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }
    public void setBillTotalPaid(double billTotalPaid) {
        this.billTotalPaid = billTotalPaid;
    }
    public void setBillToPay(double billToPay) {
        this.billToPay = billToPay;
    }
    public String getBillCode() {
        return billCode;
    }
    public double getBillTotal() {
        return billTotal;
    }
    public double getBillTotalPaid() {
        return billTotalPaid;
    }
    public double getBillToPay() {
        return billToPay;
    }
}
