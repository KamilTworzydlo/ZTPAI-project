package pl.tworzydlo.ztpai.dto;

import java.math.BigDecimal;

public record ProductDto(
        Integer id,
        String name,
        String description,
        BigDecimal pricePerDay,
        String categoryName
) {}
