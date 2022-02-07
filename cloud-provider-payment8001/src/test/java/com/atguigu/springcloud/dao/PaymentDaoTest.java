package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentDaoTest {
    @Autowired
    PaymentDao paymentDao;
    @Test
    void create() {
        Payment payment = new Payment();
        payment.setSerial("abc");
        int i = paymentDao.create(payment);
        System.out.println("i = " + i);
    }

    @Test
    void getPaymentById() {
        Long id = 1L;
        Payment payment = paymentDao.getPaymentById(id);
        System.out.println("payment = " + payment);
    }
}