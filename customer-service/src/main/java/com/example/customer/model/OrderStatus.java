package com.example.customer.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum OrderStatus {

    INITIATED ("Initiated"),
    SUCCESS ("Success"),
    NOT_AVAILABLE("NotAvailable"),
    CANCELLED("Cancelled");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

}
