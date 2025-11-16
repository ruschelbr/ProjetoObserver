package com.ecommerce;

import com.ecommerce.cliente.ClienteCadastrado;
import com.ecommerce.produto.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEcommerce {
    
    private static Scanner scanner = new Scanner(System.in);
    private static List<Produto> produtos = new ArrayList<>();
    private static List<ClienteCadastrado> clientes = new ArrayList<>();
    private static int produtoId = 0;
    private static int clienteId = 0;
    
    public static void main(String[] args) {
        exibirBemVindo();
        menuPrincipal();
    }
    
    private static void exibirBemVindo() {
        String linha = new String(new char[70]).replace("\0", "=");
        System.out.println("\n");
        System.out.println(linha);
        System.out.println("SISTEMA DE E-COMMERCE COM PADRAO OBSERVER - VERSAO INTERATIVA");
        System.out.println("Notificacoes Automaticas de Produtos em Promocao");
        System.out.println(linha + "\n");
    }
    
    private static void menuPrincipal() {
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n" + new String(new char[50]).replace("\0", "-"));
            System.out.println("MENU PRINCIPAL");
            System.out.println(new String(new char[50]).replace("\0", "-"));
            System.out.println("1. Criar novo Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Cadastrar novo Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Cliente observar Produto");
            System.out.println("6. Cliente parar de observar Produto");
            System.out.println("7. Alterar Preco de Produto");
            System.out.println("8. Alterar Estoque de Produto");
            System.out.println("9. Ver Historico de Notificacoes de Cliente");
            System.out.println("10. Ver Resumo do Sistema");
            System.out.println("0. Sair");
            System.out.println(new String(new char[50]).replace("\0", "-"));
            System.out.print("Escolha uma opcao: ");
            
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1:
                    criarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    cadastrarCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    clienteObservarProduto();
                    break;
                case 6:
                    clientePararObservar();
                    break;
                case 7:
                    alterarPrecoProduto();
                    break;
                case 8:
                    alterarEstoqueProduto();
                    break;
                case 9:
                    verHistoricoCliente();
                    break;
                case 10:
                    verResumoSistema();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\nEncerrando sistema... Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
        
        scanner.close();
    }
    
    private static void criarProduto() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("CRIAR NOVO PRODUTO");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        System.out.println("\nEscolha o tipo de produto:");
        System.out.println("1. Eletronico");
        System.out.println("2. Roupa");
        System.out.println("3. Alimenticio");
        System.out.print("Opcao: ");
        
        int tipo = lerInteiro();
        
        System.out.print("Nome do produto: ");
        scanner.nextLine(); // limpa buffer
        String nome = scanner.nextLine();
        
        System.out.print("Descricao: ");
        String descricao = scanner.nextLine();
        
        System.out.print("Preco: ");
        double preco = lerDouble();
        
        System.out.print("Estoque: ");
        int estoque = lerInteiro();
        
        Produto produto = null;
        
        switch (tipo) {
            case 1:
                System.out.print("Voltagem: ");
                int voltagem = lerInteiro();
                produto = new ProdutoEletronico(nome, descricao, preco, estoque, voltagem);
                break;
            case 2:
                System.out.print("Tamanho (P/M/G/GG): ");
                scanner.nextLine();
                String tamanho = scanner.nextLine();
                produto = new ProdutoRoupa(nome, descricao, preco, estoque, tamanho);
                break;
            case 3:
                System.out.print("Data de Validade (yyyy-MM-dd): ");
                scanner.nextLine();
                String dataStr = scanner.nextLine();
                LocalDate validade = LocalDate.parse(dataStr);
                produto = new ProdutoAlimenticio(nome, descricao, preco, estoque, validade);
                break;
            default:
                System.out.println("Tipo invalido!");
                return;
        }
        
        if (produto != null) {
            produtos.add(produto);
            System.out.println("\n✓ Produto criado com sucesso!");
            System.out.println(produto);
        }
    }
    
    private static void listarProdutos() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("LISTA DE PRODUTOS");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("\n[" + i + "] " + produtos.get(i));
            System.out.println("    Observadores: " + produtos.get(i).getObservadoresCount());
        }
    }
    
    private static void cadastrarCliente() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("CADASTRAR NOVO CLIENTE");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        System.out.print("Nome do cliente: ");
        scanner.nextLine(); // limpa buffer
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        ClienteCadastrado cliente = new ClienteCadastrado(nome, email);
        clientes.add(cliente);
        
        System.out.println("\n✓ Cliente cadastrado com sucesso!");
        System.out.println(cliente);
    }
    
    private static void listarClientes() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("LISTA DE CLIENTES");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("[" + i + "] " + clientes.get(i));
        }
    }
    
    private static void clienteObservarProduto() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("CLIENTE OBSERVAR PRODUTO");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        if (clientes.isEmpty() || produtos.isEmpty()) {
            System.out.println("Necessario ter pelo menos um cliente e um produto cadastrados.");
            return;
        }
        
        listarClientes();
        System.out.print("\nEscolha o indice do cliente: ");
        int clienteIdx = lerInteiro();
        
        if (clienteIdx < 0 || clienteIdx >= clientes.size()) {
            System.out.println("Indice invalido!");
            return;
        }
        
        listarProdutos();
        System.out.print("\nEscolha o indice do produto: ");
        int produtoIdx = lerInteiro();
        
        if (produtoIdx < 0 || produtoIdx >= produtos.size()) {
            System.out.println("Indice invalido!");
            return;
        }
        
        ClienteCadastrado cliente = clientes.get(clienteIdx);
        Produto produto = produtos.get(produtoIdx);
        
        produto.adicionarCliente(cliente);
    }
    
    private static void clientePararObservar() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("CLIENTE PARAR DE OBSERVAR");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        if (clientes.isEmpty() || produtos.isEmpty()) {
            System.out.println("Necessario ter pelo menos um cliente e um produto cadastrados.");
            return;
        }
        
        listarClientes();
        System.out.print("\nEscolha o indice do cliente: ");
        int clienteIdx = lerInteiro();
        
        if (clienteIdx < 0 || clienteIdx >= clientes.size()) {
            System.out.println("Indice invalido!");
            return;
        }
        
        listarProdutos();
        System.out.print("\nEscolha o indice do produto: ");
        int produtoIdx = lerInteiro();
        
        if (produtoIdx < 0 || produtoIdx >= produtos.size()) {
            System.out.println("Indice invalido!");
            return;
        }
        
        ClienteCadastrado cliente = clientes.get(clienteIdx);
        Produto produto = produtos.get(produtoIdx);
        
        produto.removerCliente(cliente);
    }
    
    private static void alterarPrecoProduto() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("ALTERAR PRECO DE PRODUTO");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        
        listarProdutos();
        System.out.print("\nEscolha o indice do produto: ");
        int produtoIdx = lerInteiro();
        
        if (produtoIdx < 0 || produtoIdx >= produtos.size()) {
            System.out.println("Indice invalido!");
            return;
        }
        
        Produto produto = produtos.get(produtoIdx);
        System.out.println("\nPreco atual: R$ " + String.format("%.2f", produto.getPreco()));
        System.out.print("Novo preco: R$ ");
        double novoPreco = lerDouble();
        
        System.out.println();
        produto.setPreco(novoPreco);
    }
    
    private static void alterarEstoqueProduto() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("ALTERAR ESTOQUE DE PRODUTO");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        
        listarProdutos();
        System.out.print("\nEscolha o indice do produto: ");
        int produtoIdx = lerInteiro();
        
        if (produtoIdx < 0 || produtoIdx >= produtos.size()) {
            System.out.println("Indice invalido!");
            return;
        }
        
        Produto produto = produtos.get(produtoIdx);
        System.out.println("\nEstoque atual: " + produto.getEstoque() + " unidades");
        System.out.print("Novo estoque: ");
        int novoEstoque = lerInteiro();
        
        System.out.println();
        produto.setEstoque(novoEstoque);
    }
    
    private static void verHistoricoCliente() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("HISTORICO DE NOTIFICACOES DO CLIENTE");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        
        listarClientes();
        System.out.print("\nEscolha o indice do cliente: ");
        int clienteIdx = lerInteiro();
        
        if (clienteIdx < 0 || clienteIdx >= clientes.size()) {
            System.out.println("Indice invalido!");
            return;
        }
        
        ClienteCadastrado cliente = clientes.get(clienteIdx);
        cliente.exibirHistoricoNotificacoes();
    }
    
    private static void verResumoSistema() {
        System.out.println("\n" + new String(new char[50]).replace("\0", "="));
        System.out.println("RESUMO DO SISTEMA");
        System.out.println(new String(new char[50]).replace("\0", "="));
        
        System.out.println("\nESTATISTICAS DE PRODUTOS:");
        System.out.println("  Total de produtos: " + produtos.size());
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("  [" + i + "] " + produtos.get(i).getNome() + 
                             " - Observadores: " + produtos.get(i).getObservadoresCount());
        }
        
        System.out.println("\nESTATISTICAS DE CLIENTES:");
        System.out.println("  Total de clientes: " + clientes.size());
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("  [" + i + "] " + clientes.get(i).getNome() + 
                             " - Notificacoes recebidas: " + clientes.get(i).getTotalNotificacoes());
        }
        
        System.out.println();
    }
    
    private static int lerInteiro() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // limpa buffer
            return -1;
        }
    }
    
    private static double lerDouble() {
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine(); // limpa buffer
            return -1;
        }
    }
}