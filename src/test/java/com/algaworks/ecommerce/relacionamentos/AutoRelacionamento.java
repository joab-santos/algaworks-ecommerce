package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutoRelacionamento extends EntityManagerTest {


    @Test
    public void verificaRelacionamento() {

        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônicos");

        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");
        categoria.setCategoriaPai(categoriaPai);

        Categoria categoria1 = new Categoria();
        categoria1.setNome("Notebooks");
        categoria1.setCategoriaPai(categoriaPai);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoria);
        entityManager.persist(categoria1);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria cateforiaVerificacao = entityManager.find(Categoria.class, categoria.getId());
        Assertions.assertNotNull(cateforiaVerificacao.getCategoriaPai());

        Categoria categoriaPaiVerificacao = entityManager.find(Categoria.class, categoriaPai.getId());
        Assertions.assertFalse(categoriaPaiVerificacao.getCategorias().isEmpty());

        System.out.println(categoriaPaiVerificacao.getNome());
        categoriaPaiVerificacao.getCategorias().forEach(c -> System.out.println("  " + c.getNome()));

    }
}
