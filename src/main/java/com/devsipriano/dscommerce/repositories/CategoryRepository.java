package com.devsipriano.dscommerce.repositories;

import com.devsipriano.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
