package com.pp.cs.sales.quotes.service;

import com.pp.cs.sales.quotes.dtos.QuoteReqDto;
import com.pp.cs.sales.quotes.dtos.QuoteRespDto;
import com.pp.cs.sales.quotes.entity.QuoteEntity;

import java.util.List;

public interface QuotesService {
    public QuoteRespDto createQuote(QuoteReqDto reqDto);

    public List<QuoteEntity> getAllQuotes();
}
