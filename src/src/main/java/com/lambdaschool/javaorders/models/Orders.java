package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long ord_num;

    private double ordamount;
    private double advanceamount;
    private String order_desc;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    private Customers customer;

    @ManyToMany
    @JoinTable(name = "orderpayments", joinColumns = @JoinColumn(),
            inverseJoinColumns = @JoinColumn(name = "payment_id"))
    private Set<Payments> payments = new HashSet<>();

    public Orders() {

    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrder_desc() {
        return order_desc;
    }

    public void setOrder_desc(String order_desc) {
        this.order_desc = order_desc;
    }

    public Set<Payments> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payments> payments) {
        this.payments = payments;
    }
}
