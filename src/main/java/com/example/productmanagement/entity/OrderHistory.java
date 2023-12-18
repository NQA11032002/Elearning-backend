package com.example.productmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "OrderHistory")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer OrderID;

    @Column(name = "Status", length = 255)
    private String Status;

    @OneToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference("reference-order-orderhistory")
    private Order order;
}
