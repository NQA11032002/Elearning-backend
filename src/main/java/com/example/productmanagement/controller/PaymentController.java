package com.example.productmanagement.controller;

import com.example.productmanagement.controller.interfaces.IPaymentController;
import com.example.productmanagement.entity.Payment;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.PaymentService;
import com.example.productmanagement.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
@CrossOrigin("*")
public class PaymentController implements IPaymentController {
    @Autowired
    private PaymentService paymentService;
    @Override
    @GetMapping("")
    public ResponseObject getAllPayment() {
        return paymentService.getAllPayment();
    }

    @Override
    @PostMapping("")
    public ResponseObject insertPayment(@RequestBody Payment payment) {
        return paymentService.insertPayment(payment);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseObject updatePayment(@PathVariable("id") Integer id, Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    @Override
    @DeleteMapping("")
    public ResponseObject deletePayment(@RequestParam("id") Integer id) {
        return paymentService.deletePayment(id);
    }
}
