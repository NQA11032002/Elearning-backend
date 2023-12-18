package com.example.productmanagement.controller.interfaces;

import com.example.productmanagement.entity.Payment;
import com.example.productmanagement.response.ResponseObject;

public interface IPaymentController {
    public ResponseObject getAllPayment();
    public ResponseObject insertPayment(Payment payment);
    public ResponseObject updatePayment(Integer id, Payment payment);
    public ResponseObject deletePayment(Integer id);
}
