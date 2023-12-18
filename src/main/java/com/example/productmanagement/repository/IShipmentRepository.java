package com.example.productmanagement.repository;

import com.example.productmanagement.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipmentRepository extends JpaRepository<Shipment, Integer> {
}
