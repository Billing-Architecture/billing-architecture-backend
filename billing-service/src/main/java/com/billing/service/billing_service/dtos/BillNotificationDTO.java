package com.billing.service.billing_service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillNotificationDTO extends NotificationRequest{

    @JsonProperty("bill_code")
    private String billCode;

    @JsonProperty("bill_total")
    private Integer billTotal;

    @JsonProperty("bill_total_paid")
    private Integer billTotalPaid;

    @JsonProperty("bill_to_pay")
    private Integer billToPay;

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
    public void setBillTotal(Integer billTotal) {
        this.billTotal = billTotal;
    }
    public void setBillTotalPaid(Integer billTotalPaid) {
        this.billTotalPaid = billTotalPaid;
    }
    public void setBillToPay(Integer billToPay) {
        this.billToPay = billToPay;
    }
    public String getBillCode() {
        return billCode;
    }
    public Integer getBillTotal() {
        return billTotal;
    }
    public Integer getBillTotalPaid() {
        return billTotalPaid;
    }
    public Integer getBillToPay() {
        return billToPay;
    }
}
