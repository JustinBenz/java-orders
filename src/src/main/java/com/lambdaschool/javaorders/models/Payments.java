package com.lambdaschool.javaorders.models;

import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long payment_id;

    @Column(nullable = false, unique = true)
    private String type;

    @ManyToMany(mappedBy = "payments")
    private Set<Orders> orders = new HashSet<>();

    public Payments() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
