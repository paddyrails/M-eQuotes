package com.pp.cs.sales.quotes.api;

import com.pp.cs.sales.quotes.dtos.CreateOfferReqDto;
import com.pp.cs.sales.quotes.entity.OfferEntity;
import com.pp.cs.sales.quotes.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/sales/quotes/v1/offers", produces="application/json")
public class OffersController {

    @Autowired
    private OffersService offersService;


    @PostMapping
    public ResponseEntity<OfferEntity> createOffer(@RequestBody CreateOfferReqDto createOfferReqDto){

        return ResponseEntity.ok(this.offersService.createOffer(createOfferReqDto));
    }

}
