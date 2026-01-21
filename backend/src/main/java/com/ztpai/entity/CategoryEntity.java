package com.ztpai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    private Integer id;

    private String name;

    public Integer getId() { return id; }
    public String getName() { return name; }
}
