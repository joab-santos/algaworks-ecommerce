package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemovendoEntidadeReferenciadaTest extends EntityManagerTest {

    @Test
    public void removerEntidadeReferenciada() {
        Pedido pedido = entityManager.find(Pedido.class, 1L);

        Assertions.assertFalse(pedido.getItens().isEmpty());

        entityManager.getTransaction().begin();
        pedido.getItens().forEach(item -> entityManager.remove(item));
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assertions.assertNull(pedidoVerificacao);
    }
}
