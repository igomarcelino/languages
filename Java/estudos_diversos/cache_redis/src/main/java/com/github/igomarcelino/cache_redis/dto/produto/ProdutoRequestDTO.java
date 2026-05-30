package com.github.igomarcelino.cache_redis.dto.produto;

import org.antlr.v4.runtime.misc.NotNull;

public record ProdutoRequestDTO(
        String nome,
        Double preco
) {
}
