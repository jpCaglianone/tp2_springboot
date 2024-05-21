package com.example.tp2_springboot.model.core;

import org.springframework.data.annotation.Id;

public class Produtos {

    @Id
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double valor;
    private boolean bloqueado;

    public Produtos(){};

    public Produtos(String nome,
                    String descricao,
                    int quantidade,
                    double valor,
                    boolean bloqueado) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.bloqueado = bloqueado;
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

    public void setDescricao(String dedscricao) {
        this.descricao = dedscricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
