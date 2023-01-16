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
@EntityListeners(EntityManager.class)
@Entity(name = "bundles")
public class Bundles extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bundle_category_id", nullable = false)
    private BundleCategory bundleCategory;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "group_policy_id", nullable = false)
    private String groupPolicyId;

    @Column(name = "description", nullable = false)
    private String description;

       /*@Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;*/


    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "active", nullable = false)
    private Boolean active;

}
