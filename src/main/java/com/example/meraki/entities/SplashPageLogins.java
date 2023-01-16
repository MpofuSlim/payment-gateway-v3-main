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
@Entity(name="splash_page_logins")
public class SplashPageLogins extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    @Column(name = "location", nullable = false)
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name ="date_time", nullable = false)
    private Date date_time;
}
