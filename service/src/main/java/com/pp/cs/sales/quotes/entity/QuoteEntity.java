package com.pp.cs.sales.quotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Quotes")
@Getter
@Setter
@NoArgsConstructor
public class QuoteEntity {

    @Id
    @Column(name = "id")
    private String id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OfferEntity> offers = new ArrayList<>();;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
