/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:13
 */

package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.PaymentService.PaymentService;
import com.amazon.entity.PaymentEntity;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentSvc;

    @GetMapping("/getallpayments")
    public List<PaymentEntity> getAllPayments() {
        return paymentSvc.getAllPayments();
    }

    @PostMapping("/makepayments")
    public PaymentEntity makePayments(@RequestBody PaymentEntity paymentEntity) {
        return paymentSvc.makePayments(paymentEntity);
    }

    @PostMapping("/updatepaymentstatus/{orderId}/{paymentStatus}")
    public void updatePaymentStatus(@PathVariable Long orderId, @PathVariable String paymentStatus) {
        paymentSvc.updatePaymentStatus(orderId, paymentStatus);
    }
}
