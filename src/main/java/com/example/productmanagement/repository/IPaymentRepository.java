package com.example.productmanagement.repository;

import com.example.productmanagement.entity.Payment;
import com.example.productmanagement.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
