package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersServices customersServices;

    @GetMapping(value = "/customer/{custcode}", produces = "application/json")
    public ResponseEntity<?> findCustById(@PathVariable long custcode){
        Customer c = customersServices.findCustById(custcode);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping(value="/customer/orders", produces = "application/json")
    public ResponseEntity<?> findCustOrders(){
        List<Customer> listOrders = customersServices.findCustOrders();
        return new ResponseEntity<>(listOrders, HttpStatus.OK);
    }

    @GetMapping(value="/customer/orders/count", produces = "application/json")
    public ResponseEntity<?> getCustomerOrdNums(){
        return new ResponseEntity<>(customersServices.getCustOrdNums(), HttpStatus.OK);
    }

    @GetMapping(value = "/customer/namelike/{subname}", produces = "application/json")
    public ResponseEntity<?> findCustByNameLike(@PathVariable String subname){
        List<Customer> rtnList = customersServices.findCustByNameLike(subname);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    //POST
    @PostMapping(value = "/customer", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer){
        newCustomer.setCustcode(0);
        newCustomer = customersServices.save(newCustomer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping(value = "/customer/{custcode}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> updateEntireCustomer(@RequestBody Customer updatedCustomer, @PathVariable long custcode){
        updatedCustomer = customersServices.save(updatedCustomer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    //PATCH
    @PatchMapping(value = "/customer/{custcode}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable long custcode){
        updatedCustomer = customersServices.update(updatedCustomer, custcode);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode){
        customersServices.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
