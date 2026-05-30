package com.github.igomarcelino.cache_redis.dto.promocaododia;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public record PromocaoDoDiaRequestDTO(
        String nome,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dataPromocao,
        List<Long> idProdutos
) {
}
