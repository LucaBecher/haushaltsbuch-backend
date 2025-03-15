package com.becher.repository;

import com.becher.model.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByNameIgnoreCase(String name);

    Category findByName(String name);
}
