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
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer OrderID;

    private Date PaymentDate;

    @Column(name = "PaymentMethod", length = 255)
    private String PaymentMethod;

    @OneToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference("reference-order-payment")
    private Order order;

}
