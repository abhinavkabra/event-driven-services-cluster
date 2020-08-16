package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerOrderRequests;
import com.example.customer.model.CustomerOrderResponse;
import com.example.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> fetchAllCutomers(){
        return ResponseEntity.ok(customerService.fetchAllCustomers());
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody CustomerOrderResponse placeOrder(@RequestBody CustomerOrderRequests customerOrderRequests){
        return customerService.placeOrder(customerOrderRequests);
    }
}
