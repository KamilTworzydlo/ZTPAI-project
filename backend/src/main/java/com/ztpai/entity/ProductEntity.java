package pl.tworzydlo.ztpai.entity;

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

    // getters & setters
}
