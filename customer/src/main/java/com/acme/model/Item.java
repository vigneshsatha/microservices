package com.acme.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {
    private long id;
    private String name;
    private double price;
}
