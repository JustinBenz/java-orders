package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.repositories.AgentsRepository;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "paymentService")
public class PaymentServiceimpl implements PaymentServices{

    @Autowired
    private PaymentRepository payrepos;
}
