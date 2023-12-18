package com.example.productmanagement.controller.interfaces;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.response.ResponseObject;

public interface IOrderController {
    public ResponseObject getAllOrder();
    public ResponseObject findOrderById(Integer id);
    public ResponseObject insertOrder(Order order);
    public ResponseObject updateOrder(Integer id, Order order);
    public ResponseObject deleteOrder(Integer id);
}
