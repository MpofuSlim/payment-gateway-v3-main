package com.example.meraki.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(EntityManager.class)
@Entity(name="base_price")
public class BasePrice extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Column(name = "price", nullable = false)
    private Double price;

}
