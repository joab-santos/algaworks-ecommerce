package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    void testarEnum() {
        Cliente cliente = new Cliente();
        cliente.setId(4L);
        cliente.setNome("José Mineiro");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());

        Assertions.assertNotNull(clienteVerificacao);
    }
}
