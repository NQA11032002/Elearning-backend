package com.example.productmanagement.service.interfaces;

import com.example.productmanagement.entity.Shipment;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.entity.Order;

public interface IShipmentService {
    public ResponseObject insertShipment(Shipment shipment);
    public ResponseObject findShipmentById(Integer id);
    public ResponseObject deleteShipment(Integer id);
}
