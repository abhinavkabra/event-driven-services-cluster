package com.example.refund.listener;

import com.example.refund.events.Messaging;
import com.example.refund.events.inbound.OutOfStockEvent;
import com.example.refund.events.request.RefundInitiatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class OutOfStockEventListener {

    private Messaging messaging;

    @StreamListener(Messaging.OUT_OF_STOCK_EVENTS)
    public void handleOutOfStockEvent(OutOfStockEvent outOfStockEvent){
        log.error("Out of stock event received by refund service {}",outOfStockEvent);
        Message<RefundInitiatedEvent> build = MessageBuilder.withPayload(RefundInitiatedEvent.builder().customerEmail(outOfStockEvent.getCustomerEmail()).customerId(outOfStockEvent.getCustomerId()).orderId(outOfStockEvent.getOrderId()).requestId(outOfStockEvent.getRequestId()).build()).build();
        messaging.getRefundInitiatedChannel().send(build);
        log.error("Email service is notified for refund initated");
    }

}
