package com.ecommerce.produto;

public class ProdutoRoupa extends Produto {
    
    private String tamanho;
    
    public ProdutoRoupa(String nome, String descricao, double preco, int estoque, String tamanho) {
        super(nome, descricao, preco, estoque);
        this.tamanho = tamanho;
    }
    
    public String getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    @Override
    public String toString() {
        return String.format("ProdutoRoupa{nome='%s', tamanho='%s', preco=%.2f, estoque=%d}", nome, tamanho, preco, estoque);
    }
}