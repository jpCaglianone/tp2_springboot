package com.example.tp2_springboot.model.service;
import com.example.tp2_springboot.model.core.Produtos;
import com.example.tp2_springboot.model.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

@Service
public class ProdutosService {

    @Autowired
    ProdutosRepository produtosRepository;


    @Transactional
    public void inserirProduto(Produtos produto) {
        produtosRepository.inserirProduto(produto);
    }

    @Transactional
    public void criarTabela(){
        produtosRepository.criarTabelaProdutos();
    }

    @Transactional
    public List<Produtos> listarTodos () {
        return produtosRepository.listarTodos();
    }
}
