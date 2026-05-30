package com.github.igomarcelino.cache_redis.dto.produto;

import java.util.List;

public record ProdutosParaPromocao(
        List<Long> idsProdutos
) {
}
