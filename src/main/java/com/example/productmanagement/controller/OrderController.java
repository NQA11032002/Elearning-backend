package com.example.productmanagement.controller;

import com.example.productmanagement.controller.interfaces.IOrderController;
import com.example.productmanagement.entity.Order;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@CrossOrigin("*")
public class OrderController implements IOrderController {
    @Autowired
    private OrderService orderService;

    @Override
    @GetMapping("")
    public ResponseObject getAllOrder() {
        return orderService.getAllOrder();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseObject findOrderById(@PathVariable("id") Integer id) {
        return orderService.findOrderById(id);
    }

    @Override
    @GetMapping("/find-course/{userID}")
    public ResponseObject findOrderByUserID(@PathVariable("userID") Integer userID) {
        return orderService.findOrderByUserID(userID);
    }

    @Override
    @GetMapping("/course")
    public boolean findOrderByCourseID(@RequestParam("courseID") Integer courseID, @RequestParam("userID") Integer userID) {
        return orderService.findOrderByCourseID(courseID, userID);
    }

    @Override
    @PostMapping("")
    public ResponseObject insertOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseObject updateOrder(@PathVariable("id") Integer id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @Override
    @DeleteMapping("")
        public ResponseObject deleteOrder(@RequestParam("id") Integer id) {
        return orderService.deleteOrder(id);
    }
}