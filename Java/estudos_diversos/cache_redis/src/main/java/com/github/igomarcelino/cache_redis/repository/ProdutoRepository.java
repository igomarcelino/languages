package com.github.igomarcelino.cache_redis.repository;

import com.github.igomarcelino.cache_redis.entity.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query("SELECT p FROM Produto p WHERE p.promocaoDoDia.idPromocao IS NOT NULL")
    List<Produto> produtosEmPromocao();
}
