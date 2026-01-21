package pl.tworzydlo.ztpai.mapper;

import pl.tworzydlo.ztpai.dto.ProductDto;
import pl.tworzydlo.ztpai.entity.ProductEntity;

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
