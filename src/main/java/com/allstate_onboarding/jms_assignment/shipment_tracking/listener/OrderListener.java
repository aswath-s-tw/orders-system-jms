package com.allstate_onboarding.jms_assignment.shipment_tracking.listener;

import com.allstate_onboarding.jms_assignment.order_acknowledgement.model.Order;
import com.allstate_onboarding.jms_assignment.order_acknowledgement.model.OrderStatus;
import com.allstate_onboarding.jms_assignment.order_acknowledgement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @Autowired
    private OrderRepository orderRepository;

    @JmsListener(destination = "orders_topic")
    public void processMessage(Order order) throws InterruptedException {
        Order orderFromDb = orderRepository.findById(order.getId())
                .orElseThrow();

        System.out.println("Started processing..." + order);
        orderFromDb.setStatus(OrderStatus.PROCESSING);
        Order orderInProcessingState = orderRepository.save(orderFromDb);
        Thread.sleep(20*1000);

        System.out.println("Shipped order with id " + order.getId() + " to " + order.getShippingAddress());
        orderInProcessingState.setStatus(OrderStatus.SHIPPED);
        orderRepository.save(orderInProcessingState);
    }

}
