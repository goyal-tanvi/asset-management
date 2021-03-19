package com.asset.assetmanagement.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="category")
public class Category implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryId;
    private String name;
    private String description;

    public Category(String category_id, Long id, String name, String description) {
        this.categoryId = categoryId;
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(String categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
