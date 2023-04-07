package com.algaworks.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PagamentoBoleto {

    @EqualsAndHashCode.Include
    @Id
    private Long id;

    private Long pedidoId;

    private StatusPagamento status;

    private String codigoBarras;

}
