package com.example.productmanagement.service.interfaces;

import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.entity.Order;

public interface IOrderService {
    public ResponseObject getAllOrder();
    public ResponseObject findOrderById(Integer id);
    public ResponseObject getOrderByUserID(Integer userID);
    public ResponseObject insertOrder(Order order);
    public ResponseObject updateOrder(Integer id, Order order);
    public ResponseObject deleteOrder(Integer id);
}
