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

@Entity(name="orders")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "business_partner_id", nullable = false)
    private BusinessPartner businessPartner;

    @ManyToOne(optional = false)
    @JoinColumn(name = "admin_portal_users_id", nullable = false)
    private AdminPortalUsers adminPortalUsers;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "paying_account_number", nullable = false)
    private String payingAccountNumber;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;







}
