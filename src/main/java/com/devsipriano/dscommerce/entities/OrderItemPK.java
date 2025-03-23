package com.devsipriano.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// É um chave composta, de uma tabela que relaciona outras duas, usandos os dois ids
@Embeddable //Marca para ser usado no Id do OrderItem
public class OrderItemPK {

    // A tabela do meio usara dois muitos pra um, fazendo assim um muitos pra muitos nas tabelas das pontas
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItemPK() {

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
