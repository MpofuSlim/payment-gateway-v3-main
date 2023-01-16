package com.example.meraki.entities;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "vouchers")

public class Vouchers extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bundle_id", nullable = false)
    private Bundles bundle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "voucher_code", nullable = false)
    private String voucherCode;

    @Column(name = "encrypted_voucher_code", nullable = false, unique = true)
    private String encryptedVoucherCode;

    @Column(name = "serial_number", nullable = false)
    private Integer serialNumber;

    @Column(name = "approved_by", nullable = false)
    private Integer approvedBy;

    @Column(name = "approved", nullable = false)
    private Integer approved;

    @Column(name = "used", nullable = false)
    private Boolean used;

    @Column(name = "isBlocked", nullable = false)
    private Boolean isBlocked;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "sold", nullable = false)
    private Boolean sold = false;


}
