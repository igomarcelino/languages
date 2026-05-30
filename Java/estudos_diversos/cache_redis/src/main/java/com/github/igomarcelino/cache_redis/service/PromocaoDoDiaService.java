package com.github.igomarcelino.cache_redis.service;

import com.github.igomarcelino.cache_redis.dto.promocaododia.PromocaoDoDiaRequestDTO;
import com.github.igomarcelino.cache_redis.dto.promocaododia.PromocaoDoDiaResponseDTO;
import com.github.igomarcelino.cache_redis.entity.model.Produto;
import com.github.igomarcelino.cache_redis.entity.model.PromocaoDoDia;
import com.github.igomarcelino.cache_redis.repository.PromocaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocaoDoDiaService {

    @Autowired
    PromocaoRepository promocaoRepository;

    @Autowired
    ProdutoService produtoService;

    //todo implementar o promocao repository

    public PromocaoDoDiaResponseDTO save(PromocaoDoDiaRequestDTO requestDTO){
        PromocaoDoDia promocaoDoDia = new PromocaoDoDia();
        promocaoDoDia.setNomePromocao(requestDTO.nome());
        promocaoDoDia.setProdutos(List.of());
        promocaoDoDia.setDataPromocao(requestDTO.dataPromocao());

        var promocaoCriada = promocaoRepository.save(promocaoDoDia);
        return new PromocaoDoDiaResponseDTO(promocaoCriada);
    }

    @Transactional
   public PromocaoDoDiaResponseDTO inserirProdutosNaPromocao(Long idPromocao,List<Long> idProdutos){
        var promocao = getEntityById(idPromocao);
        var produtos = produtoService.getProdutosPorIds(idProdutos);
        produtos.forEach(promocao::adicionaProdutoNaPromocao);
        return new PromocaoDoDiaResponseDTO(promocao);
    }

    public List<PromocaoDoDiaResponseDTO> getAll(){
        return promocaoRepository.findAll()
                .stream()
                .map(PromocaoDoDiaResponseDTO::new)
                .toList();
    }

    private PromocaoDoDia getEntityById(Long id){
        return promocaoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Promocao nao localizada!"));
    }
}
