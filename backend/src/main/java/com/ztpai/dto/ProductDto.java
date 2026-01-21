package com.ztpai.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Produkt dostepny do wynajmu")
public record ProductDto(

        @Schema(example = "1", description = "Unikalny identyfikator produktu")
        Integer id,

        @Schema(example = "Wall formwork 1m2", description = "Nazwa produktu")
        String name,

        @Schema(example = "Steel wall formwork", description = "Opis produktu")
        String description,

        @Schema(example = "20.00", description = "Cena wynajmu za jeden dzien")
        BigDecimal pricePerDay,

        @Schema(example = "Wall formwork", description = "Kategoria produktu")
        String categoryName
) {}
