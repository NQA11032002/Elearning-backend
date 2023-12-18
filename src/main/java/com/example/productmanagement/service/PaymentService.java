package com.example.productmanagement.service;

import com.example.productmanagement.entity.Order;
import com.example.productmanagement.entity.Payment;
import com.example.productmanagement.repository.IOderRepository;
import com.example.productmanagement.repository.IPaymentRepository;
import com.example.productmanagement.response.ResponseObject;
import com.example.productmanagement.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentRepository iPaymentRepository;
    @Override
    public ResponseObject getAllPayment() {
        List<Payment> payments = iPaymentRepository.findAll();

        if (payments.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No payments found in table", payments);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found " + payments.size() + " payments in the table", payments);
    }

    @Override
    public ResponseObject insertPayment(Payment payment) {
        try {
            iPaymentRepository.save(payment);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new payment successful", payment);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new payment failed", e.getMessage());

        }
    }

    @Override
    public ResponseObject updatePayment(Integer id, Payment payment) {
        try {
            var foundPayment = iPaymentRepository.findById(id);

            if (!foundPayment.isPresent()) {
                return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No payment found", null);
            }

            Payment updatedPayment = foundPayment.get();

            updatedPayment.setPaymentMethod(payment.getPaymentMethod());

            iPaymentRepository.save(updatedPayment);

            return new ResponseObject(HttpStatus.OK.name(), "Update payment with the given ID: " + payment.getId() + " successful", payment);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the order update process", e.getMessage());
        }
    }

    @Override
    public ResponseObject deletePayment(Integer id) {
        try {
            var foundPayment = iPaymentRepository.findById(id);

            if (foundPayment.isPresent()) {
                iPaymentRepository.delete(foundPayment.get());

                return new ResponseObject(HttpStatus.OK.name(), "Delete payment with the given ID: " + id + " successful", null);
            }

            return new ResponseObject(HttpStatus.OK.name(), "No payment found to update with the given ID: " + id, null);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the order delete process", null);
        }
    }
}
