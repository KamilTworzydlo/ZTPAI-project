package com.ztpai.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "RENTAL_ITEM")
public class RentalItemEntity {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "RENTAL_ID")
    private RentalEntity rental;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    private Integer quantity;
    private BigDecimal pricePerDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RentalEntity getRental() {
        return rental;
    }

    public void setRental(RentalEntity rental) {
        this.rental = rental;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
