package com.example.refund;

import com.example.refund.events.Messaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Messaging.class)
public class RefundApplication {
    public static void main(String[] args) {
        SpringApplication.run(RefundApplication.class, args);
    }
}
