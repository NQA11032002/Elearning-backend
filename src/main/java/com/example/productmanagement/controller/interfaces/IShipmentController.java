package com.example.productmanagement.controller.interfaces;

import com.example.productmanagement.entity.Shipment;
import com.example.productmanagement.response.ResponseObject;

public interface IShipmentController {
    public ResponseObject insertShipment(Shipment shipment);
    public ResponseObject findShipmentById(Integer id);
    public ResponseObject deleteShipment(Integer id);
}
