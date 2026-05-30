package com.github.igomarcelino.cache_redis.dto.produto;

import com.github.igomarcelino.cache_redis.entity.model.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        double preco
) {
    public ProdutoResponseDTO(Produto produto){
        this(
                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getPrecoProduto()
        );
    }
}
