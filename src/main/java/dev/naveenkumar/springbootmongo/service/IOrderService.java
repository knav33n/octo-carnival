package dev.naveenkumar.springbootmongo.service;

import dev.naveenkumar.springbootmongo.model.Order;

import java.util.List;

public interface IOrderService {
    void saveOrder(Order order);

    List<Order> ordersOfUser(String userId);
}
