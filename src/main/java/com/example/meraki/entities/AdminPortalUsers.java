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
@Entity(name = "admin_portal_users")
public class AdminPortalUsers extends BaseEntity{

        private static final long serialVersionUID = 1L;

       /* @ManyToOne(optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;*/

        @ManyToOne(optional = false)
        @JoinColumn(name = "role_id", nullable = false)
        private Role role;

        @Column(name = "firstname", nullable = false)
        private String firstname;

        @Column(name = "surname", nullable = false)
        private String surname;

        @Column(name = "email_address", unique = true)
        private String emailAddress;

        @Column(name = "password", nullable = false)
        private String password;

       /* @Temporal(TemporalType.TIMESTAMP)
        @CreatedBy
        @Column(name = "date_created", nullable = false)
        private  Date date_created;*/

        @Column(name = "active", nullable = false)
        private Boolean active;

    }


