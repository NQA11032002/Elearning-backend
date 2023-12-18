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
@Table(name = "OrderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer OrderID;

    private Integer ProductID;

    private Integer Quantity;

    private Double Price;

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference("reference-order-orderitem")
    private Order order;

}
