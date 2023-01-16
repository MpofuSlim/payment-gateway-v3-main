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
@Entity(name = "currency")
public class Currency extends BaseEntity{

    private static final long serialVersionUID = 1L;

     @ManyToOne(optional = false)
     @JoinColumn(name = "user_id", nullable = false)
     private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Column(name = "symbol", length = 4)
    private String symbol;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
