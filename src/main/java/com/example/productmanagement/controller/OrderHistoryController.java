package com.example.productmanagement.controller;

import com.example.productmanagement.controller.interfaces.IOrderHistoryController;
import com.example.productmanagement.entity.OrderHistory;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.OrderHistoryService;
import com.example.productmanagement.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orderhistory")
@CrossOrigin("*")
public class OrderHistoryController implements IOrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;
    @Override
    @PostMapping("")
    public ResponseObject insertOrderHistory(@RequestBody OrderHistory orderHistory) {
        return orderHistoryService.insertOrderHistory(orderHistory);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseObject findOrderHistoryById(@PathVariable("id")  Integer id) {
        return orderHistoryService.findOrderHistoryById(id);
    }


    @Override
    @DeleteMapping("")
    public ResponseObject deleteOrderHistory(@RequestParam("id") Integer id) {
        return orderHistoryService.deleteOrderHistory(id);
    }
}
