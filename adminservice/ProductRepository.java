package com.harshitha.ecommercemicroservices.adminservice.repository;

import com.harshitha.ecommercemicroservices.adminservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
