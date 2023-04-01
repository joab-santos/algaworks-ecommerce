package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    @DisplayName("Atualizar objeto gerenciado")
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class,1L);
        produto.setNome("Kindle Peperwhite 2ª geração");

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assertions.assertEquals("Kindle Peperwhite 2ª geração", produtoVerificacao.getNome());
    }
    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Kindle Peperwhite");
        produto.setDescricao("Conheça o novo Kindle");
        produto.setPreco(new BigDecimal(599));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assertions.assertNotNull(produtoVerificacao);
        Assertions.assertEquals("Kindle Peperwhite", produtoVerificacao.getNome());
    }


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