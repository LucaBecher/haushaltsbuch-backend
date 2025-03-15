package com.becher.model.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;


@Entity
public class Category extends BaseDao {

    private String name;

    private Long parentId;
    
    public Category() {}
    
    public Category(Long id, String name, Long parentId) {
        this.setId(id);
        this.name = name;
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
