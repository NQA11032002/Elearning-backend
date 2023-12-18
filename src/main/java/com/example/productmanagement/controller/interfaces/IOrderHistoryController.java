package com.example.productmanagement.controller.interfaces;

import com.example.productmanagement.entity.OrderHistory;
import com.example.productmanagement.response.ResponseObject;

public interface IOrderHistoryController {
    public ResponseObject insertOrderHistory(OrderHistory orderHistory);
    public ResponseObject findOrderHistoryById(Integer id);
    public ResponseObject deleteOrderHistory(Integer id);
}
