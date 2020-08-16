package com.example.email.listener;

import com.example.email.events.Messaging;
import com.example.email.events.inbound.RefundInitiatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.handler.support.MessagingMethodInvokerHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RefundIntiatedListener {

    @StreamListener(Messaging.REFUND_INITIATED_EVENTS)
    public void handleRefundInitiated(RefundInitiatedEvent refundInitiatedEvent){
        log.info("Email service received refund initiated event {}",refundInitiatedEvent);
        log.info("Customer is notified with email {} for refund intiated", refundInitiatedEvent.getCustomerEmail());
    }

}
