package com.example.productmanagement.repository;

import com.example.productmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderRepository extends JpaRepository<Order, Integer> {
}
