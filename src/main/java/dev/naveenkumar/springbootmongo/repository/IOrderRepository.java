package dev.naveenkumar.springbootmongo.repository;

import dev.naveenkumar.springbootmongo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOrderRepository extends MongoRepository<Order, String> {

    List<Order> findByUserId(String userId);
}
