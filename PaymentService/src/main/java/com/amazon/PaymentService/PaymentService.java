/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:23
 */

package com.amazon.PaymentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.PaymentRepository.PaymentRepository;
import com.amazon.entity.PaymentEntity;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    public List<PaymentEntity> getAllPayments() {
        return paymentRepo.findAll();
    }

    public PaymentEntity makePayments(PaymentEntity paymentEntity) {
        return paymentRepo.save(paymentEntity);
    }

    public void updatePaymentStatus(Long orderId, String paymentStatus) {
        paymentRepo.updatePaymentStatus(orderId, paymentStatus);
    }

}
