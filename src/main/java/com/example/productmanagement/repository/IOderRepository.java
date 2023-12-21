package com.example.productmanagement.repository;

import com.example.productmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOderRepository extends JpaRepository<Order, Integer> {
    public Order findByCourseIDAndUserID(Integer courseID, Integer userID);

    public List<Order> findByUserID(Integer userID);
}
