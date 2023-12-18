package com.example.productmanagement.service;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.entity.Shipment;
import com.example.productmanagement.repository.IOderRepository;
import com.example.productmanagement.repository.IShipmentRepository;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.interfaces.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService implements IShipmentService {

    @Autowired
    private IShipmentRepository shipmentRepository;

    @Override
    public ResponseObject insertShipment(Shipment shipment) {
        try {
            shipmentRepository.save(shipment);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new ship successful", shipment);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new shipment failed", e.getMessage());

        }
    }

    @Override
    public ResponseObject findShipmentById(Integer id) {
        var shipment = shipmentRepository.findById(id);

        if (!shipment.isPresent()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No shipment found with the given ID: " + id, shipment);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found shipment with the given ID: " + id, shipment.get());
    }

    @Override
    public ResponseObject deleteShipment(Integer id) {
        try {
            var foundOrder = shipmentRepository.findById(id);

            if (foundOrder.isPresent()) {
                shipmentRepository.delete(foundOrder.get());

                return new ResponseObject(HttpStatus.OK.name(), "Delete shipment with the given ID: " + id + " successful", null);
            }

            return new ResponseObject(HttpStatus.OK.name(), "No shipment found to update with the given ID: " + id, null);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the order delete process", null);
        }
    }
}
