package org.vamshi.microservices.controller;


import org.vamshi.microservices.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order saveOrder(Order order);
}
