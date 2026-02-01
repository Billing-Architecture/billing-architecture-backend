package com.billing.service.billing_service.dtos;

public class NotificationRequest {
    private Long referenceId;
    private String notificationReceiver;
    private String notificationSubject;
    private String notificationMessage;
    private String notificationReferenceType;

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }
    public void setNotificationReceiver(String notificationReceiver) {
        this.notificationReceiver = notificationReceiver;
    }
    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }
    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }
    public void setNotificationReferenceType(String notificationReferenceType) {
        this.notificationReferenceType = notificationReferenceType;
    }
    public Long getReferenceId() {
        return referenceId;
    }
    public String getNotificationReceiver() {
        return notificationReceiver;
    }
    public String getNotificationSubject() {
        return notificationSubject;
    }
    public String getNotificationMessage() {
        return notificationMessage;
    }
    public String getNotificationReferenceType() {
        return notificationReferenceType;
    }
}
