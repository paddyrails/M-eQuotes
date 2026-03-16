package com.pp.cs.sales.quotes.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuoteReqDto {
    private List<OfferReqDto> offers;
}
