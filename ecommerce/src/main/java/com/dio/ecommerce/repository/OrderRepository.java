package com.dio.ecommerce.repository;

import com.dio.ecommerce.model.Order;
import com.dio.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
