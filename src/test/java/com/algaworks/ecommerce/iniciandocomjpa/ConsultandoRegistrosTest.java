package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    @DisplayName("Buscar por identificador")
    public void buscarPorIdentificador() {
        Produto produto = entityManager.find(Produto.class, 1L);
//      Produto produto = entityManager.getReference(Produto.class, 1L);

        System.out.println("aqui");
        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Kindle", produto.getNome());
    }

    @Test
    @DisplayName("Atualiza a referência")
    public void atualizarAReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone Samson");

        entityManager.refresh(produto);

        Assertions.assertEquals("Kindle", produto.getNome());
    }

}