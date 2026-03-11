/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:13
 */

package com.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.custom.DialogDetails;
import com.amazon.entity.Order;
import com.amazon.feign.ProductClient;
import com.amazon.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private DialogDetails dlgDtls;

    @Autowired
    private ProductClient prodClient;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private PaymentServiceCaller paymentServiceCaller;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public String placeOrders(Order order) {
        if (!prodClient.findByProductID(order.getProductId()).isPresent()) {
            return dlgDtls.getORDSVC_MSG1();
        }

        order.setOrderStatus("ORDERED");
        order.setPaymentStatus("PENDING");

        Optional<Order> existingOrder = orderRepo.findExistingProductID(order.getProductId());

        if (existingOrder.isPresent()) {
            Order ord = existingOrder.get();
            if ("PAID".equalsIgnoreCase(ord.getPaymentStatus())) {
                return dlgDtls.getORDSVC_MSG2();
            }
            Long orderId = ord.getOrderId();
            return processPayment(orderId);
        }
        Order savedOrder = orderRepo.save(order);
        return processPayment(savedOrder.getOrderId());
    }

    private String processPayment(Long orderId) {
        String paymentSvcRes = paymentServiceCaller.callPaymentClient(orderId);
        if ("Payment Success".equalsIgnoreCase(paymentSvcRes)) {
            orderRepo.updatePaymentStatus(orderId, "PAID");
            return dlgDtls.getORDSVC_MSG3();
        }
        return dlgDtls.getORDSVC_MSG6();
    }

}
