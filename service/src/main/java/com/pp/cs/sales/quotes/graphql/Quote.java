package com.pp.cs.sales.quotes.graphql;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * GraphQL-facing shape for {@code type Quote} in schema.graphqls.
 * Class name must match the GraphQL type name so Spring GraphQL can map results.
 */
@Getter
@AllArgsConstructor
public class Quote {

    private final List<Offer> offers;
}
