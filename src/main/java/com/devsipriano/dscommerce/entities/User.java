package com.devsipriano.dscommerce.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity //Diz para jpa que essa classe é uma entidade
@Table(name = "tb_user") //Nomeia no manco de dados a tabela como tb_user
public class User {

    @Id //Gera esse campo como Id no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera um Id automaticamente quando iserido um usuário
    private Long id;
    private String name;
    @Column(unique = true) //No banco não havera repetição
    private String email;
    private String phone;
    private Date birthDate;
    private String password;

    @OneToMany(mappedBy = "client") //no lado do muitos, nossa classe ta mapeada como client
    private List<Order> orders = new ArrayList<>(); //Um para muitos cria uma lista

    public User() {
    }

    public User(Long id, String name, String email, String phone, Date birthDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
