package com.devsipriano.dscommerce.repositories;

import com.devsipriano.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
