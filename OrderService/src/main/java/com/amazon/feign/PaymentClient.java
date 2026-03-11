/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:12
 */

package com.amazon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amazon.dto.PaymentDTO;

@FeignClient(name = "PaymentService", url = "http://localhost:8083")
public interface PaymentClient {

    @PostMapping("payment/makepayments")
    public PaymentDTO makePayments(@RequestBody PaymentDTO payment);

    @PostMapping("payment/updatepaymentstatus/{orderId}/{paymentStatus}")
    public void updatePaymentStatus(@PathVariable Long orderId, @PathVariable String paymentStatus);
}
