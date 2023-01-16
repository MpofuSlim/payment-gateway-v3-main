package com.example.meraki.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Entity(name = "role")
    public class Role extends BaseEntity{

        @Column(name = "role", nullable = false)
        private String role;

        @Column(name = "active", nullable = false)
        private Boolean active;
    }

