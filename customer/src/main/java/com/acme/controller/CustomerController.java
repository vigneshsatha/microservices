package com.acme.controller;

import com.acme.model.Customer;
import com.acme.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers() {
        ResponseEntity responseEntity = ResponseEntity.ok().body(this.customerService.findAll());
        return responseEntity;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") String customerId) {
        ResponseEntity responseEntity = ResponseEntity.ok().body(this.customerService.findById(customerId));
        return responseEntity;
    }


    @PostMapping()
    public ResponseEntity<Customer> postCustomer(@Valid @RequestBody @NotNull(message = "All fields are required") Customer customer) {
        ResponseEntity responseEntity = ResponseEntity.ok().body(this.customerService.save(customer));
        return responseEntity;
    }
}
