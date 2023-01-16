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
@Entity(name="splash_page_connections")
public class SplashPageConnections extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    @ManyToOne(optional = false)
    @JoinColumn(name = "voucher_id", nullable = false)
    private Vouchers vouchers;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name ="connected_time", nullable = false)
    private Date connected_time;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "isConnected", nullable = false)
    private Boolean isConnected;
}
