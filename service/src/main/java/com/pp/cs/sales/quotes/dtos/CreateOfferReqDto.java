package com.pp.cs.sales.quotes.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CreateOfferReqDto {
    private String offerCode;
    private  String productCode;
    private BigDecimal basePrice;
    private  BigDecimal calculatedPrice;
    private  BigDecimal discountApplied;
    private BigDecimal price;
}
