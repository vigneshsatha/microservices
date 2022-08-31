package com.acme.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    private String id;

    @Column(name = "first_name")
    @NotBlank(message = "First Name is required")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "address_line_1")
    @NotBlank(message = "Address Line 1 is required")
    private String addressLine1;

    @Column(name = "address_line_2")
    @NotBlank(message = "Address Line 2 is required")
    private String addressLine2;

    @Transient
    private Order order;
}
