package com.pp.cs.sales.quotes.graphql;

import com.pp.cs.sales.quotes.entity.QuoteEntity;
import com.pp.cs.sales.quotes.service.QuotesService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QuotesQueryResolver {

    private final QuotesService quotesService;

    public QuotesQueryResolver(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @QueryMapping
    public List<Quote> quotes() {
        return this.quotesService.getAllQuotes().stream()
                .map(this::toQuote)
                .toList();
    }

    private Quote toQuote(QuoteEntity quoteEntity) {
        List<Offer> offers = quoteEntity.getOffers().stream()
                .map(offer -> new Offer(
                        offer.getOfferCode(),
                        offer.getProductCode(),
                        offer.getBasePrice(),
                        offer.getCalculatedPrice(),
                        offer.getDiscountApplied(),
                        offer.getPrice()))
                .toList();

        return new Quote(offers);
    }
}
