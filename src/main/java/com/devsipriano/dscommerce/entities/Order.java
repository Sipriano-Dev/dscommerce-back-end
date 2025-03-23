package com.devsipriano.dscommerce.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Salva sem time zone, utc horario de greenwhich
    private Date moment;
    private OrderStatus status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne //Muitos para um
    @JoinColumn(name = "client_id") //Cria uma coluna foreign key na tabela tb_order com nome de client_id
    private User client;

    public Order() {
    }

    public Order(Date moment, OrderStatus status, User client, Payment payment) {
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
