package com.example.productmanagement.service.interfaces;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.entity.Payment;
import com.example.productmanagement.response.ResponseObject;

public interface IPaymentService {
    public ResponseObject getAllPayment();
    public ResponseObject insertPayment(Payment payment);
    public ResponseObject updatePayment(Integer id, Payment payment);
    public ResponseObject deletePayment(Integer id);
}
