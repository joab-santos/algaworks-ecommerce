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
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

    @EqualsAndHashCode.Include
    @Id
    private Long id;

    @Column(name="pedido_id")
    private Long pedidoId;

    private StatusPagamento status;

    private String numero;

}
