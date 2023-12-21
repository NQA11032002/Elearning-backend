package com.example.productmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "orderID")
    private Integer orderID;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @Column(name = "paymentMethod", length = 255)
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "orderID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference("reference-payment-order")
    private Order order;

}
