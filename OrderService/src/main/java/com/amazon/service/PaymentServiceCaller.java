/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:13
 */

package com.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.custom.DialogDetails;
import com.amazon.dto.PaymentDTO;
import com.amazon.feign.PaymentClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;

@Service
public class PaymentServiceCaller {

    @Autowired
    private DialogDetails dlgDtls;

    @Autowired
    private PaymentClient paymentClient;

    @Transactional
    @CircuitBreaker(name = "PaymentCB", fallbackMethod = "checkPaymentAPI")
    public String callPaymentClient(Long orderID) {
        PaymentDTO pay = new PaymentDTO();
        pay.setOrderId(orderID);
        pay.setPaymentStatus("PROCESSING");
        pay.setPaymentMode("GPAY");

        paymentClient.makePayments(pay);
        paymentClient.updatePaymentStatus(pay.getOrderId(), "PAID");
        return dlgDtls.getORDSVC_MSG7();
    }

    public String checkPaymentAPI(Long orderID, Exception ex) {
        throw new RuntimeException(dlgDtls.getORDSVC_MSG4());
    }
}
