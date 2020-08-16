package com.example.stock.listener;

import com.example.stock.events.Messaging;
import com.example.stock.events.requests.OutOfStockEvent;
import com.example.stock.events.requests.inbound.CustomerOrderRequestEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class StockEventListener {

    private Messaging messaging;

    @StreamListener(Messaging.CUSTOMER_ORDER_CHANNEL)
    public void handleCustomerOrderRequets(CustomerOrderRequestEvent customerOrderRequestEvent){
        log.info("Event received {}",customerOrderRequestEvent);
        OutOfStockEvent outOfStockEvent = OutOfStockEvent.builder().
                customerEmail(customerOrderRequestEvent.getCustomerEmail()).
                requestId(customerOrderRequestEvent.getRequestId()).
                customerId(customerOrderRequestEvent.getCustomerId()).
                orderId(customerOrderRequestEvent.getOrderId())
                .build();
        Message<OutOfStockEvent> build = MessageBuilder.withPayload(outOfStockEvent).build();
        messaging.outStockNotification().send(build);
        log.info("Event Out Of Stock is notified {} ",outOfStockEvent);
    }
}
