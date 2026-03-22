package com.pp.cs.sales.quotes.graphql;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * GraphQL-facing shape for {@code type Offer} in schema.graphqls.
 * Class name must match the GraphQL type name so Spring GraphQL can map results.
 */
@Getter
@AllArgsConstructor
public class Offer {

    private final String offerCode;
    private final String productCode;
    private final BigDecimal basePrice;
    private final BigDecimal calculatedPrice;
    private final BigDecimal discountApplied;
    private final BigDecimal price;
}
