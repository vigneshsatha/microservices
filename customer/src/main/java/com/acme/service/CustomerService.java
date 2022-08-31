package com.acme.service;

import com.acme.clients.OrderServiceClient;
import com.acme.model.Order;
import com.acme.repo.CustomerRepo;
import com.acme.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    private OrderServiceClient orderServiceClient;

    @Autowired
    public void setOrderServiceClient(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }

    public List<Customer> findAll() {
        List<Customer> customers = StreamSupport.stream(this.customerRepo.findAll().spliterator(), false).map((customer -> {
            Order order = this.orderServiceClient.getOrder(customer.getId());
            customer.setOrder(order);
            return customer;
        })).collect(Collectors.toList());
        return customers;
    }

    public Optional<Customer> findById(String customerId) {
        Optional<Customer> customer =  this.customerRepo.findById(customerId);
        if(customer.isPresent()) {
            Order order = this.orderServiceClient.getOrder(customerId);
            customer.get().setOrder(order);
        }
        return customer;
    }

    @Transactional
    public Customer save(Customer customer) {
        UUID uuid = UUID.randomUUID();
        customer.setId(uuid.toString());
        return this.customerRepo.save(customer);
    }
}
