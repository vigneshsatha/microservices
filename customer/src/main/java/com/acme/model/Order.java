package com.acme.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class Order implements Serializable {
    private long id;
    private String customerId;
    private Set<Item> items;
}
