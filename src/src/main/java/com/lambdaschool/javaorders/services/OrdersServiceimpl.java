package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
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

    @Transactional
    @Override
    public Order save(Order order){
        Order newOrder = new Order();
        if(order.getOrdnum() != 0){
            orderepo.findById(order.getOrdnum()).orElseThrow(() -> new EntityNotFoundException("Customer" + order.getOrdnum() + " was not found!"));
            newOrder.setOrdnum(order.getOrdnum());
        }
        return orderepo.save(newOrder);
    }

    @Transactional
    @Override
    public Order update(Order updatedOrder, long ordnum) {
        return orderepo.save(updatedOrder);
    }

    @Transactional
    @Override
    public void delete(long ordnum){
        if(orderepo.findById(ordnum).isPresent()){
            orderepo.deleteById(ordnum);
        } else {
            throw new EntityNotFoundException("Restaurant " + ordnum + "not found!");
        }
    }

}
