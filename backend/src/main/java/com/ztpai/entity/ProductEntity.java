package com.ztpai.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    private Integer id;

    private String name;
    private String description;

    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPricePerDay() { return pricePerDay; }
    public CategoryEntity getCategory() { return category; }
}
