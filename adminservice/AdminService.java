package com.harshitha.ecommercemicroservices.adminservice.service;

import com.harshitha.ecommercemicroservices.adminservice.entity.Product;
import com.harshitha.ecommercemicroservices.adminservice.entity.Order;
import com.harshitha.ecommercemicroservices.adminservice.repository.ProductRepository;
import com.harshitha.ecommercemicroservices.adminservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public AdminService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    // Product management
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Order management
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
