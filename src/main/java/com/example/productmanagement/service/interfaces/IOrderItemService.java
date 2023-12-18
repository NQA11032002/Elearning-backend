package com.example.productmanagement.service.interfaces;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.entity.OrderItem;
import com.example.productmanagement.response.ResponseObject;

public interface IOrderItemService {
    public ResponseObject getAllOrderItem();
    public ResponseObject findOrderItemById(Integer id);
    public ResponseObject insertOrderItem(OrderItem orderitem);
}
