package com.example.productmanagement.repository;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
}
