package com.ztpai.service;

import com.ztpai.dto.ProductCreateUpdateDto;
import com.ztpai.dto.ProductDto;
import com.ztpai.entity.CategoryEntity;
import com.ztpai.entity.ProductEntity;
import com.ztpai.mapper.ProductMapper;
import com.ztpai.repository.CategoryRepository;
import com.ztpai.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(
            ProductRepository productRepository,
            CategoryRepository categoryRepository
    ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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

    public ProductDto createProduct(ProductCreateUpdateDto dto) {
        CategoryEntity category = categoryRepository
                .findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        ProductEntity entity = new ProductEntity();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPricePerDay(dto.pricePerDay());
        entity.setCategory(category);

        return ProductMapper.toDto(productRepository.save(entity));
    }

    public ProductDto updateProduct(int id, ProductCreateUpdateDto dto) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CategoryEntity category = categoryRepository
                .findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPricePerDay(dto.pricePerDay());
        entity.setCategory(category);

        return ProductMapper.toDto(productRepository.save(entity));
    }

    public void deleteProduct(int id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
