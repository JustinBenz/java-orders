package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;

public interface OrdersServices {
    Order findOrdById(long ordnum);
    Order save(Order order);
    Order update(Order updatedOrder, long ordnum);
    void delete(long ordnum);
}
