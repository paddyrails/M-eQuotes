package com.pp.cs.sales.quotes.dao;

import com.pp.cs.sales.quotes.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesDao extends JpaRepository<QuoteEntity, String> {
}
