package com.github.igomarcelino.cache_redis.controller;

import com.github.igomarcelino.cache_redis.dto.produto.ProdutosParaPromocao;
import com.github.igomarcelino.cache_redis.dto.promocaododia.PromocaoDoDiaRequestDTO;
import com.github.igomarcelino.cache_redis.dto.promocaododia.PromocaoDoDiaResponseDTO;
import com.github.igomarcelino.cache_redis.entity.model.PromocaoDoDia;
import com.github.igomarcelino.cache_redis.service.PromocaoDoDiaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/promocao-do-dia")
public class PromocaoDoDiaController {

    @Autowired
    PromocaoDoDiaService promocaoDoDiaService;

    @PostMapping
    public ResponseEntity<PromocaoDoDiaResponseDTO> save(@RequestBody PromocaoDoDiaRequestDTO dtoRequest,
                                                         UriComponentsBuilder uriBuilder){
        var promocao = promocaoDoDiaService.save(dtoRequest);
        URI uri = uriBuilder.path("/promocao-do-dia/{id}").buildAndExpand(promocao.id()).toUri();
        return ResponseEntity.created(uri).body(promocao);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PromocaoDoDiaResponseDTO> inserirProdutos(@PathVariable Long id,@RequestBody ProdutosParaPromocao idsProdutos){
        var promocaoAlterada = promocaoDoDiaService.inserirProdutosNaPromocao(id,idsProdutos);
        return ResponseEntity.ok(promocaoAlterada);
    }

    @GetMapping
    public ResponseEntity<List<PromocaoDoDiaResponseDTO>> getAll(){
        return ResponseEntity.ok(promocaoDoDiaService.getAll());
    }
}
