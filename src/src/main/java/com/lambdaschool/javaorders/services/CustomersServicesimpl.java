package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
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

    @Transactional
    @Override
    public Customer save(Customer customer){
        Customer newCustomer = new Customer();
        if(customer.getCustcode() != 0){
            custrepos.findById(customer.getCustcode()).orElseThrow(() -> new EntityNotFoundException("Customer" + customer.getCustcode() + " was not found!"));
            newCustomer.setCustcode(customer.getCustcode());
        }
        return custrepos.save(newCustomer);
    }

    @Transactional
    @Override
    public Customer update(Customer updatedCustomer, long custcode) {
        return custrepos.save(updatedCustomer);
    }

    @Transactional
    @Override
    public void delete(long custcode){
        if(custrepos.findById(custcode).isPresent()){
            custrepos.deleteById(custcode);
        } else {
            throw new EntityNotFoundException("Restaurant " + custcode + "not found!");
        }
    }
}
