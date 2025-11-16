package com.ecommerce.produto;

import com.ecommerce.observer.ClienteObservador;
import java.util.ArrayList;
import java.util.List;

public abstract class Produto {
    
    protected String nome;
    protected String descricao;
    protected double preco;
    protected int estoque;
    protected List<ClienteObservador> observadores;
    
    public Produto(String nome, String descricao, double preco, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.observadores = new ArrayList<>();
    }
    
    public void adicionarCliente(ClienteObservador cliente) {
        if (!observadores.contains(cliente)) {
            observadores.add(cliente);
            System.out.println("[SISTEMA] Cliente adicionado para observar: " + this.nome);
        } else {
            System.out.println("[AVISO] Cliente ja esta observando este produto!");
        }
    }
    
    public void removerCliente(ClienteObservador cliente) {
        if (observadores.contains(cliente)) {
            observadores.remove(cliente);
            System.out.println("[SISTEMA] Cliente removido de observar: " + this.nome);
        } else {
            System.out.println("[AVISO] Cliente nao estava observando este produto!");
        }
    }
    
    protected void notificarClientes(String evento) {
        System.out.println("\n[NOTIFICACAO] Produto '" + this.nome + "' - Evento: " + evento);
        System.out.println("[NOTIFICACAO] Enviando para " + observadores.size() + " clientes interessados...");
        
        for (ClienteObservador cliente : observadores) {
            cliente.receberNotificacao(this, evento);
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double novoPreco) {
        if (novoPreco != this.preco) {
            double precoAnterior = this.preco;
            this.preco = novoPreco;
            
            String evento = "PRECO_ALTERADO";
            String descricaoEvento = String.format("Preco alterado: R$ %.2f -> R$ %.2f", precoAnterior, novoPreco);
            System.out.println("[EVENTO] " + descricaoEvento);
            
            notificarClientes(evento);
        }
    }
    
    public int getEstoque() {
        return estoque;
    }
    
    public void setEstoque(int novaQuantidade) {
        boolean estavaEsgotado = (this.estoque == 0);
        boolean agoraTemEstoque = (novaQuantidade > 0);
        
        this.estoque = novaQuantidade;
        
        if (estavaEsgotado && agoraTemEstoque) {
            String evento = "REESTOQUE";
            String descricaoEvento = String.format("Produto voltou ao estoque! Quantidade: %d unidades", novaQuantidade);
            System.out.println("[EVENTO] " + descricaoEvento);
            
            notificarClientes(evento);
        }
    }
    
    public int getObservadoresCount() {
        return observadores.size();
    }
    
    @Override
    public String toString() {
        return String.format("Produto{nome='%s', preco=%.2f, estoque=%d}", nome, preco, estoque);
    }
}