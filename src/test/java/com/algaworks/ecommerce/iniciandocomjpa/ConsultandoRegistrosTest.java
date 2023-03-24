package com.algaworks.ecommerce.iniciandocomjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class ConsultandoRegistrosTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    // Antes de tudo cria uma fabrica de conexão
    @BeforeAll
    public static void setUpBeforeAll() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
    }

    // Após tudo fecha uma fabrica a conexão
    @AfterAll
    public static void tearDownAfterAll() {
        entityManagerFactory.close();
    }

    // Antes de cada teste abre a conexão
    @BeforeEach
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Após cada teste fecha a conexão
    @AfterEach
    public void tearDown() {
        entityManager.close();
    }

}