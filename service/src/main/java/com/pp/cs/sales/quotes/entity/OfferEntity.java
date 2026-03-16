package com.pp.cs.sales.quotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Offers")
@Getter
@Setter
@NoArgsConstructor
public class OfferEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "offer_code", nullable = false)
    private String offerCode;

    @Column(name = "product_code", nullable = false)
    private  String productCode;

    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @Column(name = "calculated_price", nullable = false)
    private  BigDecimal calculatedPrice;

    @Column(name = "discount_applied", nullable = false)
    private  BigDecimal discountApplied;

    @Column(name="price", nullable = false)
    private BigDecimal price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
