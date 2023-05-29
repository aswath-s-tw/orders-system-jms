package com.allstate_onboarding.jms_assignment.order_acknowledgement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String customerName;

    @NotBlank
    private String email;

    @NotBlank
    private String shippingAddress;


    private Integer totalAmount;
    private Date orderDate;

    @OneToMany(cascade = CascadeType.ALL)
    @Valid
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;
}
