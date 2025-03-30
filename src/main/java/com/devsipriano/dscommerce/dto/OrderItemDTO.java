package com.devsipriano.dscommerce.dto;

import com.devsipriano.dscommerce.entities.OrderItem;

public class OrderItemDTO {

    private Long product_id;
    private String name;
    private Double price;
    private Integer quantity;

    public OrderItemDTO(Long product_id, String name, Double price, Integer quantity) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity) {
        product_id = entity.getProduct().getId();
        this.name = entity.getProduct().getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
    }

    public Long getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubtotal(){
        return price * quantity;
    }
}
