package com.allstate_onboarding.jms_assignment.order_acknowledgement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String productId;

    @NotBlank
    private String productName;
    private Integer unitPrice;
    private Integer quantity;
    private Integer subtotal;
}
