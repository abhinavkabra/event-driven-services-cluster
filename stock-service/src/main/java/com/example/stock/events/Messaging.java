package com.example.stock.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Messaging {

    String CUSTOMER_ORDER_CHANNEL = "customer-order-placed-events";
    String OUT_STOCK_CHANNEL = "out-of-stock-events";

    @Input(CUSTOMER_ORDER_CHANNEL)
    SubscribableChannel customerOrderPlacedEvents();

    @Output(OUT_STOCK_CHANNEL)
    MessageChannel outStockNotification();

}
