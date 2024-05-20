package com.example.tp2_springboot.model.repository;
import com.example.tp2_springboot.model.core.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class ProdutosRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProdutosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void inserirProduto(Produtos produto) {
        String sql = "INSERT INTO produtos (" +
                "nome, " +
                "descricao, " +
                "quantidade, " +
                "valor, " +
                "bloqueado) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                produto.getNome(),
                produto.getDescricao(),
                produto.getQuantidade(),
                produto.getValor(),
                produto.isBloqueado());
    }

    public void criarTabelaProdutos(){
        String sql = "CREATE TABLE IF NOT EXISTS produtos ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nome VARCHAR(255) NOT NULL,"
                + "descricao VARCHAR(255),"
                + "quantidade INT,"
                + "valor DOUBLE,"
                + "bloqueado BOOLEAN"
                + ")";
        jdbcTemplate.update(sql);
    }


    public List<Produtos> listarTodos(){
        String sql = "SELECT * FROM produtos";
        List<Produtos> produtos = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            Produtos produto = new Produtos();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setValor(rs.getDouble("valor"));
            produto.setBloqueado(rs.getBoolean("bloqueado"));
            return produto;
        });
        return produtos;
    }
}
