package com.devsipriano.dscommerce.repositories;

import com.devsipriano.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
