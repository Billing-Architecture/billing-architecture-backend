package com.billing.service.billing_service.dtos.notification;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillNotificationDTO extends NotificationRequest{

    @JsonProperty("bill_code")
    private String billCode;

    @JsonProperty("bill_issue_date")
    private LocalDateTime billIssueDate;

    @JsonProperty("details")
    private DetailsDTO details;

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
    public void setBillIssueDate(LocalDateTime billIssueDate) {
        this.billIssueDate = billIssueDate;
    }
    public void setDetails(DetailsDTO details) {
        this.details = details;
    }
    public String getBillCode() {
        return billCode;
    }
    public LocalDateTime getBillIssueDate() {
        return billIssueDate;
    }
    public DetailsDTO getDetails() {
        return details;
    }
}
