package com.github.igomarcelino.cache_redis.data_initializ;

import com.github.igomarcelino.cache_redis.entity.model.Produto;
import com.github.igomarcelino.cache_redis.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitialzr implements CommandLineRunner {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Produto> produtos = new ArrayList<>();

        Produto produto1 = new Produto();
        produto1.setNomeProduto("Barbeador");
        produto1.setPrecoProduto(33.00);
        produtos.add(produto1);

        Produto produto2 = new Produto();
        produto2.setNomeProduto("Escova rotativa");
        produto2.setPrecoProduto(100.00);
        produtos.add(produto2);

        Produto produto3 = new Produto();
        produto3.setNomeProduto("Massageador");
        produto3.setPrecoProduto(150.00);
        produtos.add(produto3);

        Produto produto4 = new Produto();
        produto4.setNomeProduto("Prancha para cabelos");
        produto4.setPrecoProduto(75.00);
        produtos.add(produto4);

        produtoRepository.saveAll(produtos);

        System.out.print("MOCK INSERIDOS");
    }
}
