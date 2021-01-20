package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.views.CustomerOrderNum;

import java.util.List;

public interface CustomersServices {
    Customer findCustById(long custcode);
    List<Customer> findCustOrders();
    List<Customer> findCustByNameLike(String subname);
    List<CustomerOrderNum> getCustOrdNums();
    Customer save(Customer customer);
    Customer update(Customer updatedCustomer, long custcode);
    void delete(long custcode);
}
