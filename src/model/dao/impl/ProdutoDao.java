package model.dao.impl;

import model.entities.Produto;

import java.util.List;

public interface ProdutoDao {

    public void insert(Produto produto);
    public Integer updateById(Produto produto);
    public Integer deleteById(int id);
    Produto findById(int id);
    List<Produto> findAll();

}
