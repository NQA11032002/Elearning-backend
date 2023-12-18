package com.example.productmanagement.controller;

import com.example.productmanagement.controller.interfaces.IOrderItemController;
import com.example.productmanagement.entity.OrderItem;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.OrderHistoryService;
import com.example.productmanagement.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orderitem")
@CrossOrigin("*")
public class OrderItemController implements IOrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Override
    @GetMapping("")
    public ResponseObject getAllOrderItem() {
        return orderItemService.getAllOrderItem();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseObject findOrderItemById(@PathVariable("id") Integer id) {
        return orderItemService.findOrderItemById(id);
    }

    @Override
    @PostMapping("")
    public ResponseObject insertOrderItem(@RequestBody OrderItem orderitem) {
        return orderItemService.insertOrderItem(orderitem);
    }
}
