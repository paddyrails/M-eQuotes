package com.pp.cs.sales.quotes.dtos;

import com.pp.cs.sales.quotes.entity.OfferEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuoteRespDto {
    private String id;
    private List<OfferEntity> offers;
}
