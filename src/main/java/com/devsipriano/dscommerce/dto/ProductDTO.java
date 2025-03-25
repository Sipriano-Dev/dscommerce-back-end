package com.devsipriano.dscommerce.dto;

import com.devsipriano.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome deve ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo Requerido")
    private String name;

    @Size(min = 10, message = "Descrição dever ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo Requerido")
    private String description;

    private String imgUrl;

    @Positive(message = "O preço deve ser positivo")
    private Double price;

    public ProductDTO() {

    }

    public ProductDTO(Long id, String name, String description, String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;

    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        imgUrl = entity.getImgUrl();
        price = entity.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }



}
