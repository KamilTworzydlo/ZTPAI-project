package com.ztpai.mapper;

import com.ztpai.dto.ProductDto;
import com.ztpai.entity.ProductEntity;

public class ProductMapper {

    public static ProductDto toDto(ProductEntity entity) {
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPricePerDay(),
                entity.getCategory().getName()
        );
    }
}
