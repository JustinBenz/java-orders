package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;

public interface OrdersServices {
    Order findOrdById(long ordnum);
}
