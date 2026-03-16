package com.pp.cs.sales.quotes.dao;

import com.pp.cs.sales.quotes.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersDao extends JpaRepository<OfferEntity, String> {
}
