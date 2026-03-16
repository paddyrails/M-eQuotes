package com.pp.cs.sales.quotes.api;

import com.pp.cs.sales.quotes.dtos.QuoteReqDto;
import com.pp.cs.sales.quotes.dtos.QuoteRespDto;
import com.pp.cs.sales.quotes.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sales/quotes/v1/", produces = "application/json")
public class QuotesController {

    @Autowired
    private QuotesService quotesService;

    @PostMapping(path = "/create/quote")
    public ResponseEntity<QuoteRespDto> createQuote(@RequestBody QuoteReqDto reqDto){
        return ResponseEntity.ok(this.quotesService.createQuote(reqDto));
    }
}
