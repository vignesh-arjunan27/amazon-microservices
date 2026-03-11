/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:13
 */

package com.amazon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amazon.entity.Order;

import jakarta.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders WHERE product_id=:productID", nativeQuery = true)
    public Optional<Order> findExistingProductID(@Param("productID") Long productID);

    @Query(value = "SELECT order_id FROM orders WHERE product_id=:productID AND payment_status IN ('PENDING','FAILED')", nativeQuery = true)
    public Optional<Long> findProductIDWithPaymentPendingOrFailed(@Param("productID") Long productID);

    @Modifying
    @Transactional
    @Query(value = "UPDATE orders SET payment_status = :paymentStatus WHERE order_id = :orderID", nativeQuery = true)
    void updatePaymentStatus(@Param("orderID") Long orderID, @Param("paymentStatus") String paymentStatus);
}
