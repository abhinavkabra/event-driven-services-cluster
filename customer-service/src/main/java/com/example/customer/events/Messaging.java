package com.example.customer.events;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Messaging {

    String CUSTOMER_ORDER_CHANNEL = "customer-order-placed-events";

    @Output(CUSTOMER_ORDER_CHANNEL)
    MessageChannel customerOrderPlacedEventsChannel();

}
