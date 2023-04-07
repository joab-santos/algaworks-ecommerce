package com.algaworks.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "categoria")
public class Categoria {

    private Long id;
    private String nome;
    private Long categoriaPaiId;

    @EqualsAndHashCode.Include
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "categoria_pai_id")
    public Long getCategoriaPaiId() {
        return categoriaPaiId;
    }

    public void setCategoriaPaiId(Long categoriaPaiId) {
        this.categoriaPaiId = categoriaPaiId;
    }
}
