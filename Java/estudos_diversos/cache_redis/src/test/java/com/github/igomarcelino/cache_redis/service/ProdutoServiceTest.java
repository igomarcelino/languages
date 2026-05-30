package com.github.igomarcelino.cache_redis.service;

import com.github.igomarcelino.cache_redis.dto.produto.ProdutoRequestDTO;
import com.github.igomarcelino.cache_redis.entity.model.PromocaoDoDia;
import com.github.igomarcelino.cache_redis.repository.ProdutoRepository;
import com.github.igomarcelino.cache_redis.repository.PromocaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProdutoServiceTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PromocaoRepository promocaoRepository;

    @Autowired
    ProdutoService produtoService;

    @BeforeEach
    void setUp(){
        produtoRepository.deleteAll();
        promocaoRepository.deleteAll();
    }

    @Test
    void save() {

        ProdutoRequestDTO requestDTO = new ProdutoRequestDTO("produto teste", 10.00);
        produtoService.save(requestDTO);

        var produto = produtoRepository.findAll();
        assertNotNull(produto);
        assertEquals(1,produto.size());
        assertEquals("produto teste", produto.get(0).getNomeProduto());

    }

    @Test
    void getAllProdutos() {
    }

    @Test
    void produtosSEmPromocao() {
        ProdutoRequestDTO requestDTO = new ProdutoRequestDTO("produto teste", 10.00);
        produtoService.save(requestDTO);
        var produtoEmPromocao = produtoService.produtosEmPromocao();
        assertEquals(0, produtoEmPromocao.size());
    }

    //TODO testar produtos com promocao
}