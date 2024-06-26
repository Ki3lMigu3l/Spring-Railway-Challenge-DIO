package com.dio.ecommerce.dto;

import com.dio.ecommerce.model.OrderItem;

import java.util.List;

public record OrderDTO(String customerName, String customerEmail, List<OrderItem> items) {
}
