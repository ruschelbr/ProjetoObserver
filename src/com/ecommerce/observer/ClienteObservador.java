package com.ecommerce.observer;

import com.ecommerce.produto.Produto;

public interface ClienteObservador {
    void receberNotificacao(Produto produto, String evento);
}