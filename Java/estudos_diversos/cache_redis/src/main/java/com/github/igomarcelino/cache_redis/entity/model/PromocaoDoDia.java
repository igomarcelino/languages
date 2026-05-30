package com.github.igomarcelino.cache_redis.entity.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_promocao_do_dia")
public class PromocaoDoDia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocao;

    @Column(nullable = false)
    private String nomePromocao;

    @OneToMany(mappedBy = "idProduto", fetch = FetchType.LAZY)
    List<Produto> produtos;

    public Long getIdPromocao() {
        return idPromocao;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionaProdutoNaPromocao(Produto produto){
        if (this.produtos == null){
            this.produtos = new ArrayList<>();
        }
        this.produtos.add(produto);
        produto.setPromocaoDoDia(this);
    }
}
