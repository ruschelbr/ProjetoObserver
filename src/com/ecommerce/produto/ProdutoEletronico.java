package com.ecommerce.produto;

public class ProdutoEletronico extends Produto {
    
    private int voltagem;
    
    public ProdutoEletronico(String nome, String descricao, double preco, int estoque, int voltagem) {
        super(nome, descricao, preco, estoque);
        this.voltagem = voltagem;
    }
    
    public int getVoltagem() {
        return voltagem;
    }
    
    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }
    
    
    @Override
    public String toString() {
        return String.format("ProdutoEletronico{nome='%s', voltagem=%dV, preco=%.2f, estoque=%d}", nome, voltagem, preco, estoque);
    }
}