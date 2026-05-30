package com.github.igomarcelino.cache_redis.repository;

import com.github.igomarcelino.cache_redis.entity.model.PromocaoDoDia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<PromocaoDoDia, Long> {
}
