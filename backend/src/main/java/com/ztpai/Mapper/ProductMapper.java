package com.ztpai.mapper;

import com.ztpai.dto.ProductDto;
import com.ztpai.entity.ProductEntity;

import java.math.BigDecimal;

public class ProductMapper {

    private ProductMapper() {
    }

    public static ProductDto toDto(ProductEntity entity) {
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPricePerDay() == null
                        ? BigDecimal.ZERO
                        : BigDecimal.valueOf(entity.getPricePerDay()),
                entity.getCategory().getName()
        );
    }
}
