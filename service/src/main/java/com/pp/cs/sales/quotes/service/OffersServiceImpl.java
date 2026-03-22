package com.pp.cs.sales.quotes.service;


import com.pp.cs.sales.quotes.dao.OffersDao;
import com.pp.cs.sales.quotes.dtos.CreateOfferReqDto;
import com.pp.cs.sales.quotes.entity.OfferEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OffersServiceImpl implements OffersService{

    @Autowired
    private OffersDao offersDao;


    @Override
    public OfferEntity createOffer(CreateOfferReqDto createOfferReqDto) {
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(UUID.randomUUID().toString());
        offerEntity.setCreatedAt(LocalDateTime.now());

        offerEntity.setOfferCode(createOfferReqDto.getOfferCode());
        offerEntity.setPrice(createOfferReqDto.getPrice());
        offerEntity.setBasePrice(createOfferReqDto.getBasePrice());
        offerEntity.setDiscountApplied(createOfferReqDto.getDiscountApplied());
        offerEntity.setProductCode(createOfferReqDto.getProductCode());
        offerEntity.setCalculatedPrice(createOfferReqDto.getCalculatedPrice());

        OfferEntity newEntity = this.offersDao.save(offerEntity);
        return newEntity;
    }
}
