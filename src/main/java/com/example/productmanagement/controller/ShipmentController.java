package com.example.productmanagement.controller;

import com.example.productmanagement.controller.interfaces.IOrderController;
import com.example.productmanagement.controller.interfaces.IShipmentController;
import com.example.productmanagement.entity.Order;
import com.example.productmanagement.entity.Shipment;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.OrderService;
import com.example.productmanagement.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shipment")
@CrossOrigin("*")

public class ShipmentController implements IShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @Override
    @PostMapping("")
    public ResponseObject insertShipment(@RequestBody Shipment shipment) {
        return shipmentService.insertShipment(shipment);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseObject findShipmentById(@PathVariable("id") Integer id) {
        return shipmentService.findShipmentById(id);
    }

    @Override
    @DeleteMapping("")
    public ResponseObject deleteShipment(@RequestParam("id") Integer id) {
        return shipmentService.deleteShipment(id);
    }
}