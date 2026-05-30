package com.github.igomarcelino.cache_redis.controller;

import com.github.igomarcelino.cache_redis.dto.produto.ProdutoRequestDTO;
import com.github.igomarcelino.cache_redis.dto.produto.ProdutoResponseDTO;
import com.github.igomarcelino.cache_redis.service.ProdutoService;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> save(@RequestBody ProdutoRequestDTO dtoRequest,
                                                   UriComponentsBuilder uriBuilder){
       var produto = produtoService.save(dtoRequest);
       URI uri = uriBuilder.path("/produtos/{i}").buildAndExpand(produto.id()).toUri();
       return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getAll(){
        return ResponseEntity.ok(produtoService.getAllProdutos());
    }

    @GetMapping("/sem-promocao")
    public ResponseEntity<List<ProdutoResponseDTO>> produtosEmPromocao(){
        return ResponseEntity.ok(produtoService.produtosEmPromocao());
    }
}
