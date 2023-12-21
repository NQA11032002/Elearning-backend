package com.example.productmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userID", updatable=false)
    private Integer userID;

    @Column(name = "courseID", updatable=false)
    private Integer courseID;

    private String codeOrder;

    private Double totalPrice;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @Column(name = "Status", length = 255)
    private String status;

    @OneToOne(mappedBy = "order")
    @JsonBackReference("reference-payment-order")
    private Payment payment;
}