/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:12
 */

package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.Order;
import com.amazon.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService ordersvc;

    @GetMapping("/allorders")
    public List<Order> getAllOrders() {
        return ordersvc.getAllOrders();
    }

    @PostMapping("/placeorders")
    public ResponseEntity<?> placeOrders(@RequestBody Order order) {
        return ResponseEntity.ok(ordersvc.placeOrders(order));
    }

}
