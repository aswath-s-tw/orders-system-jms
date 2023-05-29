package com.allstate_onboarding.jms_assignment.order_acknowledgement.repository;

import com.allstate_onboarding.jms_assignment.order_acknowledgement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
