package com.ztpai.dto;

import java.math.BigDecimal;

public record ProductCreateUpdateDto(
        String name,
        String description,
        BigDecimal pricePerDay,
        Integer categoryId
) {}
