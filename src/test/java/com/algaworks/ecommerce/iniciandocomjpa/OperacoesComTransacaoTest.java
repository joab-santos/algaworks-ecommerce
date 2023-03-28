package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    @DisplayName("inserir o primeiro objeto")
    public void inserirOPrimeiroObjeto(){
        Produto produto = new Produto();

        produto.setId(2L);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos");
        produto.setPreco(new BigDecimal(5_000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assertions.assertNotNull(produtoVerificacao);
    }


    @Test
    public void abrirEFcharATransacao() {
//        Produto produto = new Produto(); //somnete para o método não mostrar erro
        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();

    }
}
