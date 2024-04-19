package com.harshitha.ecommercemicroservices.adminservice.repository;

import com.harshitha.ecommercemicroservices.adminservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
