package com.example.productmanagement.service;


import com.example.productmanagement.entity.OrderHistory;
import com.example.productmanagement.repository.IOrderHistoryRepository;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.interfaces.IOrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryService implements IOrderHistoryService {
    @Autowired
    private IOrderHistoryRepository orderHistoryRepository;


    @Override
    public ResponseObject insertOrderHistory(OrderHistory orderHistory) {
        try {
            orderHistoryRepository.save(orderHistory);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new orderHistory successful", orderHistory);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new orderHistory failed", e.getMessage());

        }
    }

    @Override
    public ResponseObject findOrderHistoryById(Integer id) {
        var orderHistory = orderHistoryRepository.findById(id);

        if (!orderHistory.isPresent()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No orderHistory found with the given ID: " + id, orderHistory);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found orderHistory with the given ID: " + id, orderHistory.get());
    }

    @Override
    public ResponseObject deleteOrderHistory(Integer id) {
        return null;
    }
}
