package com.dio.ecommerce.service;

import com.dio.ecommerce.exception.ResourceNotFoundException;
import com.dio.ecommerce.model.Order;
import com.dio.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

   public List<Order> getAllOrders () {
       return orderRepository.findAll();
   }

    public Order getOrderById(Long id) throws ResourceNotFoundException {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
