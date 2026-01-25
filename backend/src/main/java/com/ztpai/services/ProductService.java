package com.ztpai.service;

import com.ztpai.dto.ProductCreateUpdateDto;
import com.ztpai.dto.ProductDto;
import com.ztpai.entity.CategoryEntity;
import com.ztpai.entity.ProductEntity;
import com.ztpai.mapper.ProductMapper;
import com.ztpai.repository.CategoryRepository;
import com.ztpai.repository.ProductRepository;
import com.ztpai.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    // ======================
    // GET ALL
    // ======================
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    // ======================
    // GET BY ID
    // (tu już masz poprawnie – Optional + 404 w kontrolerze)
    // ======================
    public Optional<ProductDto> getProductById(int id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto);
    }

    // ======================
    // CREATE
    // ======================
    public ProductDto createProduct(ProductCreateUpdateDto dto) {

        CategoryEntity category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found: " + dto.categoryId())
                );

        ProductEntity entity = new ProductEntity();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPricePerDay(dto.pricePerDay().doubleValue());
        entity.setCategory(category);

        return ProductMapper.toDto(productRepository.save(entity));
    }

    // ======================
    // UPDATE
    // ======================
    public ProductDto updateProduct(int id, ProductCreateUpdateDto dto) {

        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found: " + id)
                );

        CategoryEntity category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found: " + dto.categoryId())
                );

        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPricePerDay(dto.pricePerDay().doubleValue());
        entity.setCategory(category);

        return ProductMapper.toDto(productRepository.save(entity));
    }

    // ======================
    // DELETE
    // ======================
    public void deleteProduct(int id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found: " + id)
                );

        productRepository.delete(entity);
    }
}
