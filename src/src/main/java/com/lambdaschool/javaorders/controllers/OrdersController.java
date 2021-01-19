package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
