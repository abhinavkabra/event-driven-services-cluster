package com.example.email.listener;

import com.example.email.events.Messaging;
import com.example.email.events.inbound.OutOfStockEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OutOfStockEventListener {

    @StreamListener(Messaging.OUT_OF_STOCK_EVENTS)
    public void handleOutOfStockEvent(OutOfStockEvent outOfStockEvent){
    log.error("Out of stock event received by email service {}",outOfStockEvent);
    log.error("Customer{} is notified for order id {} with out of stock email",outOfStockEvent.getCustomerEmail(),outOfStockEvent.getOrderId());
    }

}
