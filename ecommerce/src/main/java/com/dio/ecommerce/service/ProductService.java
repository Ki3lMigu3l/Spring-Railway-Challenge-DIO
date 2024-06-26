package com.dio.ecommerce.service;

import com.dio.ecommerce.exception.ResourceNotFoundException;
import com.dio.ecommerce.model.Product;
import com.dio.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
    }

    public Product saveProduct (Product product) {
        return repository.save(product);
    }

    public void deleteProduct (Long id) {
        repository.deleteById(id);
    }
}
