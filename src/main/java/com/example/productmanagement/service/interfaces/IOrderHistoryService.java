package com.example.productmanagement.service.interfaces;

import com.example.productmanagement.entity.OrderHistory;
import com.example.productmanagement.response.ResponseObject;

public interface IOrderHistoryService {
    public ResponseObject insertOrderHistory(OrderHistory orderHistory);
    public ResponseObject findOrderHistoryById(Integer id);
    public ResponseObject deleteOrderHistory(Integer id);
}
