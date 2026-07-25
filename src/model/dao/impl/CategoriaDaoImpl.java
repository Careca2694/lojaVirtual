package model.dao.impl;

import model.dao.CategoriaDao;

import java.sql.Connection;
import java.util.List;

public class CategoriaDaoImpl implements CategoriaDao {

    private final Connection connection;

    public CategoriaDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(CategoriaDao categoria) {

    }

    @Override
    public Integer updateById(CategoriaDao categoria) {
        return 0;
    }

    @Override
    public Integer deleteById(int id) {
        return 0;
    }

    @Override
    public CategoriaDao findById(int id) {
        return null;
    }

    @Override
    public List<CategoriaDao> findAll() {
        return List.of();
    }
}
