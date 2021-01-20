package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersServices ordersServices;

    @GetMapping(value = "/order/{ordnum}")
    public ResponseEntity<?> findOrdById(@PathVariable long ordnum){
        Order o = ordersServices.findOrdById(ordnum);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    //POST
    @PostMapping(value = "/order", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addOrder(@RequestBody Order newOrder){
        newOrder.setOrdnum((long)0);
        newOrder = ordersServices.save(newOrder);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping(value = "/customer/{ordnum}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> updateEntireOrder(@RequestBody Order updatedOrder, @PathVariable long ordnum){
        updatedOrder = ordersServices.save(updatedOrder);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(value = "/customer/{ordnum}")
    public ResponseEntity<?> deleteOrder(@PathVariable long ordnum){
        ordersServices.delete(ordnum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
