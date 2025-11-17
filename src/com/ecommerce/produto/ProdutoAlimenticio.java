package com.ecommerce.produto;

import java.time.LocalDate;

public class ProdutoAlimenticio extends Produto {
    
    private LocalDate dataValidade;
    
    public ProdutoAlimenticio(String nome, double preco, int estoque, LocalDate dataValidade) {
        super(nome, preco, estoque);
        this.dataValidade = dataValidade;
    }
    
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    @Override
    public String toString() {
        return String.format("ProdutoAlimenticio{nome='%s', validade='%s', preco=%.2f, estoque=%d}", nome, dataValidade, preco, estoque);
    }
}