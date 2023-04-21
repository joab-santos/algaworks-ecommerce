package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {


    @Test
    @DisplayName("Impedir operação com banco de dados")
    public void impedirOperacaoComBancoDeDados() {
        Produto produto = entityManager.find(Produto.class,1L);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Peperwhite 2ª geração");
        entityManager.merge(produto);
        entityManager.detach(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assertions.assertEquals("Kindle", produtoVerificacao.getNome());
    }

    @Test
    @DisplayName("mostrar diferença persist e merge")
    public void mostrarDiferencaPersistMerge(){
        Produto produtoPersist = new Produto();

        //produtoPersist.setId(5L); Comentado porque estamos utilizando IDENTITY
        produtoPersist.setNome("Smartphone One PLus");
        produtoPersist.setDescricao("O processador mais rápido");
        produtoPersist.setPreco(new BigDecimal(2_000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setNome("Smarphone Two Plus");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
        Assertions.assertNotNull(produtoVerificacaoPersist);

        System.out.println("--------------------------");

        Produto produtoMerge = new Produto();

        produtoMerge.setId(5L);
        produtoMerge.setNome("Notebook Dell");
        produtoMerge.setDescricao("O melhor da categoria.");
        produtoMerge.setPreco(new BigDecimal(2_000));

        entityManager.getTransaction().begin();
        Produto merge = entityManager.merge(produtoMerge);
        merge.setNome("Notebook Dell 2");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
        Assertions.assertNotNull(produtoVerificacaoMerge);

    }
    @Test
    @DisplayName("Inserir objeto com merge")
    public void inserirObjetoComMerge(){
        Produto produto = new Produto();

        produto.setId(4L);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A melhor qualidade de som");
        produto.setPreco(new BigDecimal(1_000));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assertions.assertNotNull(produtoVerificacao);
    }
    @Test
    public void removerObjeto() {
        Produto produto = entityManager.find(Produto.class, 3L);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.clear(); // Não é necessário na asserção para operação de remoção.

        Produto produtoVerificado = entityManager.find(Produto.class, 3L);
        Assertions.assertNull(produtoVerificado);
    }


    @Test
    @DisplayName("inserir o primeiro objeto")
    public void inserirOPrimeiroObjeto(){
        Produto produto = new Produto();

        //produto.setId(2L); Comentado porque estamos utilizando IDENTITY
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
