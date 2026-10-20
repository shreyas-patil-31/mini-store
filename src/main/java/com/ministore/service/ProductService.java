
package com.ministore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ministore.entity.Product;
import com.ministore.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findProductsByCategory(categoryId);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
