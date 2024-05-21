package com.example.tp2_springboot;

import com.example.tp2_springboot.model.service.ProdutosService;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DatabaseInitializer {
    private final ProdutosService produtosService;

    public DatabaseInitializer(ProdutosService produtosService) {
        this.produtosService = produtosService;
        produtosService.criarTabela();
        produtosService.cargaDados();
    }


}
