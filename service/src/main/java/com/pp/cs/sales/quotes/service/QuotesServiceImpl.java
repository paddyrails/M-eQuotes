package com.pp.cs.sales.quotes.service;

import com.pp.cs.sales.quotes.dao.QuotesDao;
import com.pp.cs.sales.quotes.dtos.QuoteReqDto;
import com.pp.cs.sales.quotes.dtos.QuoteRespDto;
import com.pp.cs.sales.quotes.entity.OfferEntity;
import com.pp.cs.sales.quotes.entity.QuoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuotesServiceImpl implements QuotesService {

    @Autowired
    private QuotesDao quotesDao;

    @Override
    public QuoteRespDto createQuote(QuoteReqDto reqDto) {
        QuoteEntity newQuote = new QuoteEntity();
        newQuote.setCreatedAt(LocalDateTime.now());
        newQuote.setId(UUID.randomUUID().toString());

        List<OfferEntity> newQuoteOffers = reqDto.getOffers().stream().map(offerReqDto -> {
            OfferEntity newOffer = new OfferEntity();
            newOffer.setId(UUID.randomUUID().toString());
            newOffer.setOfferCode(offerReqDto.getOfferCode());
            newOffer.setProductCode(offerReqDto.getProductCode());
            newOffer.setBasePrice(offerReqDto.getBasePrice());
            newOffer.setCalculatedPrice(offerReqDto.getCalculatedPrice());
            newOffer.setDiscountApplied(offerReqDto.getDiscountApplied());
            newOffer.setPrice(offerReqDto.getPrice());
            newOffer.setCreatedAt(LocalDateTime.now());
            return  newOffer;
        }).toList();

        newQuote.setOffers(newQuoteOffers);
        QuoteEntity createdQuote = this.quotesDao.save(newQuote);

        QuoteRespDto newQuoteRespDto = new QuoteRespDto();
        newQuoteRespDto.setId(createdQuote.getId());
        newQuoteRespDto.setOffers(createdQuote.getOffers());

        return newQuoteRespDto;
    }
}
