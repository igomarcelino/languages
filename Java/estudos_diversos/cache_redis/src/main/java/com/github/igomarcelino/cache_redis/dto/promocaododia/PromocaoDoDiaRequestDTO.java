package com.github.igomarcelino.cache_redis.dto.promocaododia;

import java.time.LocalDate;
import java.util.List;

public record PromocaoDoDiaRequestDTO(
        String nome,
        LocalDate dataPromocao,
        List<Long> idProdutos
) {
}
