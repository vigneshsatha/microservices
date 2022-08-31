package com.acme.order.controller;

import com.acme.order.model.Order;
import com.acme.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setCustomerService(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping()
    public ResponseEntity<Order> getCustomers(@RequestParam("customerId") String customerId) {
        ResponseEntity responseEntity = ResponseEntity.ok().body(this.orderService.findByCustomerId(customerId));
        return responseEntity;
    }

    @PostMapping()
    public Order postCustomer(@RequestBody @NotNull Order order) {
        return this.orderService.save(order);
    }
}
