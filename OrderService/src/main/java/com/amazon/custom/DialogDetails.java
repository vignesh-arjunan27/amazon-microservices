/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:12
 */

package com.amazon.custom;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DialogDetails {

    // OrderService
    private final String ORDSVC_MSG1 = "Product ID not found in the cart";
    private final String ORDSVC_MSG2 = "Payment already paid for this order";
    private final String ORDSVC_MSG3 = "Ordered Successfully";
    private final String ORDSVC_MSG5 = "Payment Pending";
    private final String ORDSVC_MSG6 = "Payment Failed";
    private final String ORDSVC_MSG7 = "Payment Success";

    // PaymentServiceCaller
    private final String ORDSVC_MSG4 = "Payment API is down";

}
