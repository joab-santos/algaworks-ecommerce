package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {


    @Test
    public void analisarMapeamentoObjetoEmbutido() {
        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
        endereco.setCep("00000-000");
        endereco.setLogradouro("Rua das Laranjeiras");
        endereco.setNumero("123");
        endereco.setBairro("Centro");
        endereco.setCidade("Uberlândia");
        endereco.setEstado("MG");

        Pedido pedido = new Pedido();
        //pedido.setId(1L);  Comentado porque estamos utilizando IDENTITY
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal("1000.00"));
        pedido.setEnderecoEntrega(endereco);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());

        Assertions.assertNotNull(pedidoVerificacao);
        Assertions.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assertions.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());
    }

}
