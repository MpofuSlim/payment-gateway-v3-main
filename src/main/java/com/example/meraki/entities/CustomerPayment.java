package com.example.meraki.entities;

import com.example.meraki.Config.gateway.PaymentStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="customer_payment")
public class CustomerPayment extends BaseEntity {

    public static String generateRandomBase64Token(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token); //base64 encoding
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "receipt_number", nullable = false)
    private String receiptNumber = generateRandomBase64Token(8);

    @Column(name = "email", nullable = false)
    private String email;

    //@Lob
    @Column(name = "product_title", nullable = false)
    private String productTitle;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Column(name = "status", length = 100, nullable = false)
    private PaymentStatus status = PaymentStatus.PENDING;


    public CustomerPayment(Customers customer, BigDecimal amount, String phoneNumber,Long productId,String email,String productTitle) {
        this.customer = customer;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.productId = productId;
        this.email = email;
        this.productTitle = productTitle;
    }
}
