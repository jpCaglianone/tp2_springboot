package com.example.tp2_springboot.model.service;
import com.example.tp2_springboot.model.core.Produtos;
import com.example.tp2_springboot.model.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.ArrayList;
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

    @Transactional
    public Produtos listarId (int id) {
        return produtosRepository.listarId(id);
    }

    @Transactional
    public void cargaDados() {

        List<Produtos> produtosList = new ArrayList<Produtos>();
        for (int i = 1; i < 11; i++) {
            produtosList.add((new Produtos("Produto " + i, "Descrição " + i, 2*i, 19.49*i, true)));
        }
        for (Produtos produto : produtosList) {
            produtosRepository.cargaDados(produto);
        }
    }

    @Transactional
    public boolean modificar(int id, Produtos produto) {
        try {
            produtosRepository.modificar(id, produto);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Transactional
    public boolean deletar(int id) {
        try{
            produtosRepository.deletar(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
