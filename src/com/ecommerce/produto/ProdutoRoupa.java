package com.ecommerce.produto;

public class ProdutoRoupa extends Produto {
    
    private String tamanho;
    private String cor;
    private String material;
    
    public ProdutoRoupa(String nome, String descricao, double preco, int estoque, String tamanho, String cor, String material) {
        super(nome, descricao, preco, estoque);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }
    
    public String getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public String toString() {
        return String.format("ProdutoRoupa{nome='%s', tamanho='%s', cor='%s', material='%s', preco=%.2f, estoque=%d}", nome, tamanho, cor, material, preco, estoque);
    }
}