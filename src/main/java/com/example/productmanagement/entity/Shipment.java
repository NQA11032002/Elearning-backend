package com.example.productmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer OrderID;

    @Column(name = "ShippingMethod", length = 255)
    private String ShippingMethod;

    @Column(name = "TrackingNumber", length = 255)
    private String TrackingNumber;

    private Date EstimatedDeliveryDate;

    @OneToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference("reference-order-shipment")
    private Order order;


}
