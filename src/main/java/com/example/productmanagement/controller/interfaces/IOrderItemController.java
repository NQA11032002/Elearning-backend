package com.example.productmanagement.controller.interfaces;

import com.example.productmanagement.entity.OrderItem;
import com.example.productmanagement.response.ResponseObject;

public interface IOrderItemController {
    public ResponseObject getAllOrderItem();
    public ResponseObject findOrderItemById(Integer id);

    public ResponseObject insertOrderItem(OrderItem orderitem);
}
