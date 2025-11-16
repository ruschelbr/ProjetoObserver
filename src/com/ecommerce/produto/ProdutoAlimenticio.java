package com.ecommerce.produto;

import java.time.LocalDate;

public class ProdutoAlimenticio extends Produto {
    
    private LocalDate dataValidade;
    private String[] ingredientes;
    
    public ProdutoAlimenticio(String nome, String descricao, double preco, int estoque, LocalDate dataValidade, String[] ingredientes) {
        super(nome, descricao, preco, estoque);
        this.dataValidade = dataValidade;
        this.ingredientes = ingredientes;
    }
    
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public String[] getIngredientes() {
        return ingredientes;
    }
    
    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    @Override
    public String toString() {
        return String.format("ProdutoAlimenticio{nome='%s', validade='%s', preco=%.2f, estoque=%d}", nome, dataValidade, preco, estoque);
    }
}