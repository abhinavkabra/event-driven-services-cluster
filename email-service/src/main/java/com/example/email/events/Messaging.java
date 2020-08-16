package com.example.email.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Messaging {

    String OUT_OF_STOCK_EVENTS= "out-of-stock-events";
    String REFUND_INITIATED_EVENTS = "refund-initiated-events";

    @Input(OUT_OF_STOCK_EVENTS)
    SubscribableChannel getOutOfStockChannel();

    @Input(REFUND_INITIATED_EVENTS)
    SubscribableChannel getRefundInitiatedChannel();


}
