package com.github.igomarcelino.cache_redis.dto.promocaododia;

import com.github.igomarcelino.cache_redis.dto.produto.ProdutoResponseDTO;
import com.github.igomarcelino.cache_redis.entity.model.PromocaoDoDia;

import java.time.LocalDate;
import java.util.List;

public record PromocaoDoDiaResponseDTO(
        Long id,
        String nome,
        LocalDate dataPromocao,
        List<ProdutoResponseDTO> produtos
) {
    public PromocaoDoDiaResponseDTO(PromocaoDoDia promocaoCriada) {
        this(
                promocaoCriada.getIdPromocao(),
                promocaoCriada.getNomePromocao(),
                promocaoCriada.getDataPromocao(),
                promocaoCriada.getProdutos().stream().map(ProdutoResponseDTO::new).toList()
        );
    }
}
