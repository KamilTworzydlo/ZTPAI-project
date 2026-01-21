package com.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ztpai.entity.CategoryEntity;

public interface CategoryRepository
        extends JpaRepository<CategoryEntity, Integer> {
}

