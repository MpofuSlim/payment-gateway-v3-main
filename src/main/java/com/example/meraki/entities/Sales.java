package com.example.meraki.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity(name="sales")
public class Sales extends BaseEntity{

    private static final long serialVersionUID = 1L;


    @ManyToOne(optional = false)
    @JoinColumn(name = "bundles_id", nullable = false)
    private Bundles bundles;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
