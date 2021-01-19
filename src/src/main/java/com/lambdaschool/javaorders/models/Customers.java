package com.lambdaschool.javaorders.models;

import org.aspectj.weaver.loadtime.Agent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long custcode;

    @Column(unique = true, nullable = false)
    private String custname;

    private String custcity;
    private String working_area;
    private String cust_country;
    private String grade;
    private double opening_amt;
    private double receive_amt;
    private double payment_amt;
    private double outstanding_gmt;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agent_code", nullable = false)
    private Agents agent;

    @OneToMany(mappedBy = "orders")
    private List<Orders> order = new ArrayList<>();

    public Customers() {

    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getWorking_area() {
        return working_area;
    }

    public void setWorking_area(String working_area) {
        this.working_area = working_area;
    }

    public String getCust_country() {
        return cust_country;
    }

    public void setCust_country(String cust_country) {
        this.cust_country = cust_country;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpening_amt() {
        return opening_amt;
    }

    public void setOpening_amt(double opening_amt) {
        this.opening_amt = opening_amt;
    }

    public double getReceive_amt() {
        return receive_amt;
    }

    public void setReceive_amt(double receive_amt) {
        this.receive_amt = receive_amt;
    }

    public double getPayment_amt() {
        return payment_amt;
    }

    public void setPayment_amt(double payment_amt) {
        this.payment_amt = payment_amt;
    }

    public double getOutstanding_gmt() {
        return outstanding_gmt;
    }

    public void setOutstanding_gmt(double outstanding_gmt) {
        this.outstanding_gmt = outstanding_gmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
