package com.dio.ecommerce.controller;

import com.dio.ecommerce.dto.OrderDTO;
import com.dio.ecommerce.exception.ResourceNotFoundException;
import com.dio.ecommerce.model.Order;
import com.dio.ecommerce.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders () {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) throws ResourceNotFoundException {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order createOrder (@RequestBody OrderDTO orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deletarOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
