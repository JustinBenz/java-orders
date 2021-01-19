package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long agent_code;

    @Column(unique = true, nullable = false)
    private String agent_name;

    private String working_area;
    private double commission;
    private String phone;
    private String country;

    @OneToMany(mappedBy = "agents", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customers> customers = new ArrayList<>();

    public Agents(){

    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getWorking_area() {
        return working_area;
    }

    public void setWorking_area(String working_area) {
        this.working_area = working_area;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
}
