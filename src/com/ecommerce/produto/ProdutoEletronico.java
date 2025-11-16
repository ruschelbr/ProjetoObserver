package com.ecommerce.produto;

public class ProdutoEletronico extends Produto {
    
    private int voltagem;
    private String marca;
    
    public ProdutoEletronico(String nome, String descricao, double preco, int estoque, int voltagem, String marca) {
        super(nome, descricao, preco, estoque);
        this.voltagem = voltagem;
        this.marca = marca;
    }
    
    public int getVoltagem() {
        return voltagem;
    }
    
    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString() {
        return String.format("ProdutoEletronico{nome='%s', marca='%s', voltagem=%dV, preco=%.2f, estoque=%d}", nome, marca, voltagem, preco, estoque);
    }
}