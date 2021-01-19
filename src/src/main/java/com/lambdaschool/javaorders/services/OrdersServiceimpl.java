package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "orderService")
public class OrdersServiceimpl implements OrdersServices{

    @Autowired
    private OrdersRepository orderepo;

    @Override
    public Order findOrdById(long ordnum) {
        Order o = orderepo.findById(ordnum).orElseThrow(() -> new EntityNotFoundException("Order with " + ordnum + "was not found"));
        return null;
    }
}
