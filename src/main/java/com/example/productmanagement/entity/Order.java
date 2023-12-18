package com.example.productmanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String phone;

    private String address;

    private String email;

    private String note;

    private String OrderDate;

    @Column(name = "Status", length = 255)
    private String Status;

    private Double TotalAmount;

    @OneToOne(mappedBy = "order")
    @JsonManagedReference("reference-order-orderhistory")
    private OrderHistory orderHistories;

    @OneToMany(mappedBy = "order")
    @JsonManagedReference("reference-order-orderitem")
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order")
    @JsonManagedReference("reference-order-payment")
    private Payment payment;

    @OneToOne(mappedBy = "order")
    @JsonManagedReference("reference-order-shipment")
    private Shipment shipment;
}