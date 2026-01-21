package pl.tworzydlo.ztpai.service;

import org.springframework.stereotype.Service;
import pl.tworzydlo.ztpai.dto.ProductDto;
import pl.tworzydlo.ztpai.mapper.ProductMapper;
import pl.tworzydlo.ztpai.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }
}
