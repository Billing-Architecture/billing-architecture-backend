package com.billing.service.billing_service.dtos.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillDTO {

    @JsonProperty("bill_code")
    private String billCode;

    @JsonProperty("bill_total")
    private double billTotal;

    @JsonProperty("bill_total_paid")
    private double billTotalPaid;

    @JsonProperty("bill_to_pay")
    private double billToPay;

    public String getBillCode() {
        return billCode;
    }
    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
    public double getBillTotal() {
        return billTotal;
    }
    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }
    public double getBillTotalPaid() {
        return billTotalPaid;
    }
    public void setBillTotalPaid(double billTotalPaid) {
        this.billTotalPaid = billTotalPaid;
    }
    public double getBillToPay() {
        return billToPay;
    }
    public void setBillToPay(double billToPay) {
        this.billToPay = billToPay;
    }
}
