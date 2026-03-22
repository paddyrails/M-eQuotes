package com.pp.cs.sales.quotes.dao;

import com.pp.cs.sales.quotes.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuotesDao extends JpaRepository<QuoteEntity, String> {

    /**
     * Loads quotes with offers in one query to avoid LazyInitializationException in GraphQL / REST.
     */
    @Query("SELECT DISTINCT q FROM QuoteEntity q LEFT JOIN FETCH q.offers")
    List<QuoteEntity> findAllWithOffers();
}
