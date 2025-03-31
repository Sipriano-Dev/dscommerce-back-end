package com.devsipriano.dscommerce.services;

import com.devsipriano.dscommerce.dto.OrderDTO;
import com.devsipriano.dscommerce.dto.OrderItemDTO;
import com.devsipriano.dscommerce.entities.Order;
import com.devsipriano.dscommerce.entities.OrderItem;
import com.devsipriano.dscommerce.entities.OrderStatus;
import com.devsipriano.dscommerce.entities.Product;
import com.devsipriano.dscommerce.repositories.OrderItemRepository;
import com.devsipriano.dscommerce.repositories.OrderRepository;
import com.devsipriano.dscommerce.repositories.ProductRepository;
import com.devsipriano.dscommerce.services.exceptions.ResourceNotFoundException;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {

        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        order.setClient(userService.authenticated());

        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem(order, product, product.getPrice(), itemDto.getQuantity());
            order.getItems().add(item);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);

    }
}
