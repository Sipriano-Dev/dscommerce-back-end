package com.devsipriano.dscommerce.dto;

import com.devsipriano.dscommerce.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private Double price;

    //Não faz sentido ter construtor vazio se não tem set, como inserir os dados depois?

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
