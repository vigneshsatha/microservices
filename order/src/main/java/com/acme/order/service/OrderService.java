package com.acme.order.service;

import com.acme.order.repo.OrderRepo;
import com.acme.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    @Autowired
    public void setCustomerRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order findByCustomerId(String customerId) {
        return this.orderRepo.findByCustomerId(customerId);
    }

    @Transactional
    public Order save(Order order) {
        return this.orderRepo.save(order);
    }
}
