package com.example.productmanagement.service;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.entity.OrderItem;
import com.example.productmanagement.repository.IOrderHistoryRepository;
import com.example.productmanagement.repository.IOrderItemRepository;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.interfaces.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    private IOrderItemRepository orderItemRepository;
    @Override
    public ResponseObject getAllOrderItem() {
        List<OrderItem> orderitem = orderItemRepository.findAll();

        if (orderitem.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No orderitem found in the course table", orderitem);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found " + orderitem.size() + " orders in the product table", orderitem);
    }

    @Override
    public ResponseObject findOrderItemById(Integer id) {
        var orderItem = orderItemRepository.findById(id);

        if (!orderItem.isPresent()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No orderItem found with the given ID: " + id, orderItem);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found orderItem with the given ID: " + id, orderItem.get());
    }


    @Override
    public ResponseObject insertOrderItem(OrderItem orderitem) {
        try {
            orderItemRepository.save(orderitem);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new orderitem successful", orderitem);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new orderitem failed", e.getMessage());

        }
    }
}
