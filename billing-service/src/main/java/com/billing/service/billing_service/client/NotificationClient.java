package com.billing.service.billing_service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.billing.service.billing_service.dtos.BillNotificationDTO;
import com.billing.service.billing_service.dtos.PaymentNotificationDTO;

@Component
public class NotificationClient {
    private final WebClient webClient;

    public NotificationClient (WebClient.Builder builder, @Value("${notification.service.url}") String baseUrl) {
        this.webClient = builder.baseUrl(baseUrl).build(); // configuration of webclient
    }

    public void sendNotification (BillNotificationDTO notification) {
        webClient.post()
            .uri("api/notify/bill")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(notification)
            .retrieve() //Execute the petition and wait the server
            .toBodilessEntity() //Doesn't matter what the body is, only what your state is
            .block(); //The thread wait until it receives a response
    }   

    public void sendNotification (PaymentNotificationDTO notification) {
        webClient.post()
            .uri("api/notify/payment")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(notification)
            .retrieve()
            .toBodilessEntity()
            .block();
    }
}
