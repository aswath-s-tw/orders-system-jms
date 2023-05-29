package com.allstate_onboarding.jms_assignment.order_acknowledgement.model;

import java.io.Serializable;

public enum OrderStatus implements Serializable {
    PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELED
}
