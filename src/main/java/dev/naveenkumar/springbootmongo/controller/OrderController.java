package dev.naveenkumar.springbootmongo.controller;

import dev.naveenkumar.springbootmongo.dto.OrderDto;
import dev.naveenkumar.springbootmongo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto.convertToOrder());
        return ResponseEntity.ok(true);
    }

    @GetMapping("{ userId }")
    public ResponseEntity<?> getOrdersOfUser(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.ordersOfUser(userId));
    }
}
