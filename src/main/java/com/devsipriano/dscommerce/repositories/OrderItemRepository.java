package com.devsipriano.dscommerce.repositories;

import com.devsipriano.dscommerce.entities.OrderItem;
import com.devsipriano.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
