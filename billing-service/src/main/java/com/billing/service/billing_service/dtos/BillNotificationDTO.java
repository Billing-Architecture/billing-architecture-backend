package com.billing.service.billing_service.dtos;

public class BillNotificationDTO extends NotificationRequest{
    private String billCode;
    private Integer billTotal;
    private Integer billTotalPaid;
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
