package com.allstate_onboarding.jms_assignment.order_acknowledgement.controller;

import com.allstate_onboarding.jms_assignment.order_acknowledgement.model.Order;
import com.allstate_onboarding.jms_assignment.order_acknowledgement.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JmsTemplate template;

    @PostMapping
    private ResponseEntity<Order> createOrder(
            @Valid @RequestBody Order order
    ) {
        Order savedOrder = orderRepository.save(order);
        template.convertAndSend("orders_topic", savedOrder);
        return ResponseEntity.ok(savedOrder);
    }
}
