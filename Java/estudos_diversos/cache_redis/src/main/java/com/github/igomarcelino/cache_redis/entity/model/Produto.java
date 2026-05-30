package com.github.igomarcelino.cache_redis.entity.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    @Column(nullable = false)
    private String nomeProduto;
    @Column(nullable = false)
    private Double precoProduto;

    @ManyToOne
    @JoinColumn(name = "idPromocao")
    private PromocaoDoDia promocaoDoDia;

    public Long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(idProduto, produto.idProduto) && Objects.equals(nomeProduto, produto.nomeProduto) && Objects.equals(precoProduto, produto.precoProduto);
    }

    public PromocaoDoDia getPromocaoDoDia() {
        return promocaoDoDia;
    }

    public void setPromocaoDoDia(PromocaoDoDia promocaoDoDia) {
        this.promocaoDoDia = promocaoDoDia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, nomeProduto, precoProduto);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", precoProduto=" + precoProduto +
                '}';
    }
}
