package dev.naveenkumar.springbootmongo.service;

import dev.naveenkumar.springbootmongo.model.Order;
import dev.naveenkumar.springbootmongo.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> ordersOfUser(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
