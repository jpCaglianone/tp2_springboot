package com.example.tp2_springboot.controller;

import com.example.tp2_springboot.model.core.Produtos;
import com.example.tp2_springboot.model.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutosService produtoService;

    @GetMapping
    public String Funcionando(){
        return "funcionando";
    }

    @PostMapping("/inserir")
    public String Inserir(@RequestBody Produtos produto){
        produtoService.inserirProduto(produto);
        System.out.println(produto.getNome());
        return "item inserido";
    }

    @GetMapping("/listarTodos")
    public List<Produtos> ListarTodos(){
        return produtoService.listarTodos();
    }
}
