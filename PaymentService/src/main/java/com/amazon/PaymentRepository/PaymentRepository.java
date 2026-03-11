/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:14
 */

package com.amazon.PaymentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amazon.entity.PaymentEntity;

import jakarta.transaction.Transactional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Object> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE payment SET payment_status = :paymentStatus WHERE order_id = :orderId ", nativeQuery = true)
    public void updatePaymentStatus(@Param("orderId") Long orderId,
            @Param("paymentStatus") String paymentStatus);

}
