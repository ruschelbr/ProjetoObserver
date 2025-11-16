package com.ecommerce.notificacao;

import com.ecommerce.produto.Produto;
import java.time.LocalDateTime;

public class Notificacao {
    
    private Produto produto;
    private String evento;
    private LocalDateTime dataHora;
    
    public Notificacao(Produto produto, String evento, LocalDateTime dataHora) {
        this.produto = produto;
        this.evento = evento;
        this.dataHora = dataHora;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String getEvento() {
        return evento;
    }
    
    public void setEvento(String evento) {
        this.evento = evento;
    }
    
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] Evento '%s' - Produto: %s (Preco: R$ %.2f)", 
                           dataHora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                           evento, 
                           produto.getNome(),
                           produto.getPreco());
    }
}