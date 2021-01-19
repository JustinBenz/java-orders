package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.AgentsRepository;
import com.lambdaschool.javaorders.repositories.CustomersRepository;
import com.lambdaschool.javaorders.views.CustomerOrderNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomersServicesimpl implements CustomersServices{

    @Autowired
    private CustomersRepository custrepos;

    @Override
    public Customer findCustById(long custcode) {
        Customer c = custrepos.findById(custcode).orElseThrow(() -> new EntityNotFoundException("Customer with" + custcode + "does not exist"));
        return null;
    }

    @Override
    public List<Customer> findCustOrders() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return null;
    }

    @Override
    public List<CustomerOrderNum> getCustOrdNums(){
        return custrepos.getCustomerOrdNums();
    }

    @Override
    public List<Customer> findCustByNameLike(String subname) {
        List<Customer> rtnList = custrepos.findByCustnameContainingIgnoringCase(subname);
        return rtnList;
    }
}
