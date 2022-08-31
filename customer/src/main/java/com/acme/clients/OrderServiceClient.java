package com.acme.clients;

import com.acme.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderServiceClient {

    @Value("${service.order.url}")
    private String orderServiceUrl;

    public Order getOrder(String customerId) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Order> response = restTemplate.getForEntity(orderServiceUrl + "/order?customerId=" + customerId, Order.class);
        return response.getBody();
    }

}
