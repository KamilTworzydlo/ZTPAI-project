package com.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ztpai.entity.ProductEntity;

public interface ProductRepository
        extends JpaRepository<ProductEntity, Integer> {
}
