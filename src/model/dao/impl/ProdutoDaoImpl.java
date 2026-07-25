package model.dao.impl;

import model.dao.ProdutoDao;
import model.entities.Produto;

import java.sql.Connection;
import java.util.List;

public class ProdutoDaoImpl implements ProdutoDao {

    private final Connection connection;

    public ProdutoDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Produto produto) {

    }

    @Override
    public Integer updateById(Produto produto) {
        return 0;
    }

    @Override
    public Integer deleteById(int id) {
        return 0;
    }

    @Override
    public Produto findById(int id) {
        return null;
    }

    @Override
    public List<Produto> findAll() {
        return List.of();
    }
}
