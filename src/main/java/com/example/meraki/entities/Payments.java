package com.example.meraki.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "payments")
public class Payments extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;


    @Column(name = "amountPaid", nullable = false)
    private Double amountPaid;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name = "datePaid", nullable = false)
    private Date datePaid;

    @Column(name = "paying_account", nullable = false)
    private Long paying_account;

    @Column(name = "location", nullable = false)
    private  String  location;

    @Column(name = "isPaid", nullable = false)
    private Boolean active;

}
