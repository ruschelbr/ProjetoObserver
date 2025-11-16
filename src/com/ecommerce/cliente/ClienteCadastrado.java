package com.ecommerce.cliente;

import com.ecommerce.observer.ClienteObservador;
import com.ecommerce.produto.Produto;
import com.ecommerce.notificacao.Notificacao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteCadastrado implements ClienteObservador {
    
    private String email;
    private String nome;
    private List<Notificacao> notificacoesRecebidas;
    
    public ClienteCadastrado(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.notificacoesRecebidas = new ArrayList<>();
    }
    
    @Override
    public void receberNotificacao(Produto produto, String evento) {
        System.out.println();
        System.out.println("    +============================================+");
        System.out.println("    | EMAIL RECEBIDO POR: " + String.format("%-14s", nome.toUpperCase()) + "|");
        System.out.println("    +============================================+");
        
        String mensagem = "";
        switch(evento) {
            case "PRECO_ALTERADO":
                mensagem = String.format("Preco alterado! Produto '%s' agora custa R$ %.2f", 
                                       produto.getNome(), produto.getPreco());
                break;
            case "REESTOQUE":
                mensagem = String.format("Produto '%s' voltou ao estoque! %d unidades disponiveis",
                                       produto.getNome(), produto.getEstoque());
                break;
            case "NOVO_PRODUTO":
                mensagem = String.format("Novo produto disponivel: '%s'", produto.getNome());
                break;
            default:
                mensagem = String.format("Evento: %s no produto '%s'", evento, produto.getNome());
        }
        
        System.out.println("    | " + String.format("%-40s", mensagem) + "|");
        System.out.println("    | Email: " + String.format("%-34s", email) + "|");
        System.out.println("    +============================================+");
        
        armazenarNotificacao(produto, evento);
        enviarEmail(produto, evento);
    }
    
    private void enviarEmail(Produto produto, String evento) {
        System.out.println("    [EMAIL ENVIADO] Para: " + email);
    }
    
    private void armazenarNotificacao(Produto produto, String evento) {
        Notificacao notif = new Notificacao(produto, evento, LocalDateTime.now());
        notificacoesRecebidas.add(notif);
    }
    
    public List<Notificacao> getHistoricoNotificacoes() {
        return notificacoesRecebidas;
    }
    
    public void exibirHistoricoNotificacoes() {
        String linha = new String(new char[60]).replace("\0", "=");
        System.out.println("\n" + linha);
        System.out.println("HISTORICO DE NOTIFICACOES - " + nome.toUpperCase());
        System.out.println(linha);
        
        if (notificacoesRecebidas.isEmpty()) {
            System.out.println("Nenhuma notificacao recebida ainda.");
        } else {
            for (int i = 0; i < notificacoesRecebidas.size(); i++) {
                System.out.println((i + 1) + ". " + notificacoesRecebidas.get(i));
            }
        }
        System.out.println(linha);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getTotalNotificacoes() {
        return notificacoesRecebidas.size();
    }
    
    @Override
    public String toString() {
        return String.format("ClienteCadastrado{nome='%s', email='%s', notificacoes recebidas=%d}", 
                           nome, email, notificacoesRecebidas.size());
    }
}