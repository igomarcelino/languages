package com.github.igomarcelino.cache_redis.service;

import com.github.igomarcelino.cache_redis.dto.produto.ProdutoRequestDTO;
import com.github.igomarcelino.cache_redis.dto.produto.ProdutoResponseDTO;
import com.github.igomarcelino.cache_redis.entity.model.Produto;
import com.github.igomarcelino.cache_redis.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    public ProdutoResponseDTO save(ProdutoRequestDTO dtoRequest){
        var produto = new Produto();
        produto.setNomeProduto(dtoRequest.nome());
        produto.setPrecoProduto(dtoRequest.preco());

        var produtoSalvo = produtoRepository.save(produto);

        return new ProdutoResponseDTO(produto);
    }

    public List<ProdutoResponseDTO> getAllProdutos(){
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .toList();
    }


    public List<ProdutoResponseDTO> produtosEmPromocao(){
        return produtoRepository.produtosEmPromocao()
                .stream()
                .map(ProdutoResponseDTO::new)
                .toList();
    }
}
