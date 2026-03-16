package com.pp.cs.sales.quotes.service;

import com.pp.cs.sales.quotes.dtos.QuoteReqDto;
import com.pp.cs.sales.quotes.dtos.QuoteRespDto;

public interface QuotesService {
    public QuoteRespDto createQuote(QuoteReqDto reqDto);
}
