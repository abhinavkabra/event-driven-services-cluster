package com.example.customer.service;

import com.example.customer.events.Messaging;
import com.example.customer.events.requests.CustomerOrderRequestEvent;
import com.example.customer.model.Customer;
import com.example.customer.model.CustomerOrder;
import com.example.customer.model.CustomerOrderRequests;
import com.example.customer.model.CustomerOrderResponse;
import com.example.customer.model.OrderStatus;
import com.example.customer.repository.CustomerOrderRepository;
import com.example.customer.repository.CustomerRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRespository customerRespository;

    private final CustomerOrderRepository customerOrderRepository;

    private final Messaging messaging;

    public CustomerService(CustomerRespository customerRespository, Messaging messaging, CustomerOrderRepository customerOrderRepository){
        this.customerRespository = customerRespository;
        this.messaging = messaging;
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<Customer> fetchAllCustomers(){
        return customerRespository.findAll();
    }

    public CustomerOrderResponse placeOrder(CustomerOrderRequests customerOrderRequests) {
        Optional<Customer> customer = customerRespository.findById(customerOrderRequests.getCustomerId());
        final CustomerOrderResponse[] orderStatus = new CustomerOrderResponse[1];
        customer.map(e -> {
            CustomerOrder customerOrderEntity = CustomerOrder.builder().customerId(e.getId()).itemId(customerOrderRequests.getItemId()).status(OrderStatus.INITIATED.getValue()).itemQty(customerOrderRequests.getItemQty()).requestId(UUID.randomUUID().toString()).build();
            CustomerOrder save = customerOrderRepository.save(customerOrderEntity);
            orderStatus[0] = CustomerOrderResponse.builder().orderId(save.getId()).orderStatus(save.getStatus()).build();
            CustomerOrderRequestEvent payload = CustomerOrderRequestEvent.builder().customerId(save.getCustomerId()).itemId(save.getItemId()).itemQty(save.getItemQty()).requestId(save.getRequestId()).customerEmail(e.getEmailId()).orderId(save.getId()).build();
            messaging.customerOrderPlacedEventsChannel().send(MessageBuilder.withPayload(payload).build());
            log.info("Order successfully sent to stock service {}",payload);
            return orderStatus[0];
        }).orElseGet(() -> {
            return orderStatus[0] = CustomerOrderResponse.builder().orderStatus(OrderStatus.NOT_AVAILABLE.getValue()).build();
        });
        return orderStatus[0];
    }
}
