package com.multirao.oftalmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multirao.oftalmo.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long > {

}
