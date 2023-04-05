package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    void create() {
        Cliente cliente = new Cliente();
        cliente.setId(3L);
        cliente.setNome("Aurora Bárbara Daiane Gomes");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

    }

    @Test
    void read() {
        Cliente cliente = entityManager.find(Cliente.class, 3L);

        Assertions.assertEquals("Aurora Bárbara Daiane Gomes", cliente.getNome());
    }

    @Test
    void update() {
        Cliente cliente = entityManager.find(Cliente.class, 1L);
        cliente.setNome("Pedro silva");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    @Test
    void delete() {
        Cliente cliente = entityManager.find(Cliente.class, 2L);
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }

}
