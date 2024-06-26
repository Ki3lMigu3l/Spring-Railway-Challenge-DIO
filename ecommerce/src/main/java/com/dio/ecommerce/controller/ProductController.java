package com.dio.ecommerce.controller;

import com.dio.ecommerce.dto.ProductDTO;
import com.dio.ecommerce.exception.ResourceNotFoundException;
import com.dio.ecommerce.model.Product;
import com.dio.ecommerce.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) throws ResourceNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct (@RequestBody ProductDTO productDto) {
        var product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
