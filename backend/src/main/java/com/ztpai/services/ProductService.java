package com.ztpai.service;

import org.springframework.stereotype.Service;
import com.ztpai.dto.ProductDto;
import com.ztpai.mapper.ProductMapper;
import com.ztpai.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

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

    public Optional<ProductDto> getProductById(int id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto);
    }
}
