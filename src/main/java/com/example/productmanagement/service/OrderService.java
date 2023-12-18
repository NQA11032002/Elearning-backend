package com.example.productmanagement.service;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.repository.IOderRepository;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOderRepository ioderRepository;

    @Override
    public ResponseObject getAllOrder() {
        List<Order> orders = ioderRepository.findAll();

        if (orders.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No orders found in the course table", orders);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found " + orders.size() + " orders in the product table", orders);
    }

    @Override
    public ResponseObject findOrderById(Integer id) {
        var order = ioderRepository.findById(id);

        if (!order.isPresent()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No order found with the given ID: " + id, order);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found order with the given ID: " + id, order.get());
    }

    @Override
    public ResponseObject getOrderByUserID(Integer userID) {
        var response = ioderRepository.findById(userID);
        Order order = response.get();
        if(response.isPresent()){
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "Found order in the course table", order);
        }
        return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No orders found in the course table", order);
    }

    @Override
    public ResponseObject insertOrder(Order order) {
        try {
            ioderRepository.save(order);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new order successful", order);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new order failed", e.getMessage());

        }
    }

    @Override
    public ResponseObject updateOrder(Integer id, Order order) {
        try {
            var foundOrder = ioderRepository.findById(id);

            if (!foundOrder.isPresent()) {
                return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No order found", null);
            }

            Order updatedOrder = foundOrder.get();

            updatedOrder.setStatus(order.getStatus());

            ioderRepository.save(updatedOrder);

            return new ResponseObject(HttpStatus.OK.name(), "Update order with the given ID: " + order.getId() + " successful", order);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the order update process", e.getMessage());
        }
    }


    @Override
    public ResponseObject deleteOrder(Integer id) {
        try {
            var foundOrder = ioderRepository.findById(id);

            if (foundOrder.isPresent()) {
                ioderRepository.delete(foundOrder.get());

                return new ResponseObject(HttpStatus.OK.name(), "Delete order with the given ID: " + id + " successful", null);
            }

            return new ResponseObject(HttpStatus.OK.name(), "No order found to update with the given ID: " + id, null);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the order delete process", null);
        }
    }


}
