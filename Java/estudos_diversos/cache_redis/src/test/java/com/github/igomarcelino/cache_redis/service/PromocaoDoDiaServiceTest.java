package com.github.igomarcelino.cache_redis.service;

import com.github.igomarcelino.cache_redis.dto.produto.ProdutoRequestDTO;
import com.github.igomarcelino.cache_redis.dto.produto.ProdutosParaPromocao;
import com.github.igomarcelino.cache_redis.dto.promocaododia.PromocaoDoDiaRequestDTO;
import com.github.igomarcelino.cache_redis.repository.ProdutoRepository;
import com.github.igomarcelino.cache_redis.repository.PromocaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PromocaoDoDiaServiceTest {

    @Autowired
    PromocaoRepository promocaoRepository;

    @Autowired
    PromocaoDoDiaService promocaoDoDiaService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoRepository produtoRepository;

    @BeforeEach
    void setUp(){
        promocaoRepository.deleteAll();
        produtoRepository.deleteAll();
    }

    @Test
    void save() {

        PromocaoDoDiaRequestDTO dtoRequest = new PromocaoDoDiaRequestDTO(
                "teste",
                LocalDate.of(2026, 6,3),
                List.of()
        );
        var promocaoCriada = promocaoDoDiaService.save(dtoRequest);

        assertThat(promocaoCriada).isNotNull();
        assertThat(promocaoCriada.produtos()).isEmpty();
        assertEquals("teste", promocaoCriada.nome());
    }


    @Test
    void inserirProdutosNaPromocao() {
        PromocaoDoDiaRequestDTO dtoRequest = new PromocaoDoDiaRequestDTO(
                "teste",
                LocalDate.of(2026, 6,3),
                List.of()
        );
        var promocaoCriada = promocaoDoDiaService.save(dtoRequest);

        ProdutosParaPromocao produtosParaPromocao = new ProdutosParaPromocao(criarProdutos());

        var promocaoAlterada = promocaoDoDiaService.inserirProdutosNaPromocao(promocaoCriada.id(),produtosParaPromocao);
        assertThat(promocaoAlterada).isNotNull();
        assertThat(promocaoAlterada.produtos()).isNotEmpty();
    }

    List<Long> criarProdutos(){
        List<ProdutoRequestDTO> produtosRequest = new ArrayList<>();
        List<Long> idsProduto = new ArrayList<>();
        produtosRequest.add(new ProdutoRequestDTO("produto teste", 10.00));
        produtosRequest.add(new ProdutoRequestDTO("produto teste1", 10.00));
        produtosRequest.add(new ProdutoRequestDTO("produto teste2", 10.00));
        produtosRequest.forEach(prod -> {
            idsProduto.add(produtoService.save(prod).id());
        });

        return idsProduto;
    }

}