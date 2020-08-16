package com.example.refund.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Messaging {

    String OUT_OF_STOCK_EVENTS= "out-of-stock-events";
    String REFUND_INITIATED_EVENTS = "refund-initiated-events";

    @Input(OUT_OF_STOCK_EVENTS)
    SubscribableChannel getOutOfStockChannel();

    @Output(REFUND_INITIATED_EVENTS)
    MessageChannel getRefundInitiatedChannel();

}
