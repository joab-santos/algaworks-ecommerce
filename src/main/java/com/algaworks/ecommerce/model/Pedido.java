package com.algaworks.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido" )
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    private Long id;

    @Column(name = "data_pedido" )
    private LocalDateTime dataPedido;

    @Column(name = "data_conclusao" )
    private LocalDateTime dataConclusao;

    @Column(name = "nota_fiscal_id" )
    private Long notaFiscalId;

    private BigDecimal total;

    private StatusPedido status;
}
