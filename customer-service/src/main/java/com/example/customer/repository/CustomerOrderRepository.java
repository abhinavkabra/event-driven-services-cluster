package com.example.customer.repository;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
}
