package dev.naveenkumar.springbootmongo.dto;

import dev.naveenkumar.springbootmongo.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderDto {

    private String name;
    private String userId;

    public Order convertToOrder() {
        return Order.builder().orderName(name).userId(userId).orderTime(LocalDateTime.now()).build();
    }
}
