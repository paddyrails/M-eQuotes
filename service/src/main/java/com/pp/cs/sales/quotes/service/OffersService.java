package com.pp.cs.sales.quotes.service;

import com.pp.cs.sales.quotes.dtos.CreateOfferReqDto;
import com.pp.cs.sales.quotes.entity.OfferEntity;

public interface OffersService {
    public OfferEntity createOffer(CreateOfferReqDto createOfferReqDto);


}
