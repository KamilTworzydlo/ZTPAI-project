package pl.tworzydlo.ztpai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    private Integer id;

    private String name;

    // getters & setters
}
