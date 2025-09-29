package com.lex.LexCommerce.dto;

import com.lex.LexCommerce.entities.Produto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "Campo requerido.")
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres.")
    private String nome;
    @Size(min = 10, message = "Descrição precisa ter no minimo 10 caracteres.")
    @NotBlank
    private String descricao;

    @Positive(message = "Preço deve ser positivo.")
    private Double preco;
    private String imgUrl;

    public ProdutoDTO(){}

    public ProdutoDTO(Long id, String nome, String descricao, Double preco, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public ProdutoDTO(Produto entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.preco = entity.getPreco();
        this.imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
