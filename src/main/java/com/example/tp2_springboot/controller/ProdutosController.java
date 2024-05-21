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
        return "item inserido";
    }

    @GetMapping("/listarTodos")
    public List<Produtos> ListarTodos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/listarId/{id}")
    public Produtos ListarId(@PathVariable int id){
        return produtoService.listarId(id);
    }

    @PutMapping("/modificar/{id}")
    public String Modificar(@PathVariable int id, @RequestBody Produtos produto){
        if(produtoService.modificar(id, produto)){
            return "Produto alterado com sucesso!";
        }
        else{
            return "Produto não pode ser alterado!";
        }
    }

    @DeleteMapping("deletar/{id}")
    public String Deletar(@PathVariable int id){
        if(produtoService.deletar(id)){
            return "Produto deletado com sucesso!";
        }
        else{
            return "Produto não pode ser deletado!";
        }
    }
}
