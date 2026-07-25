package model.dao;

import model.entities.Categoria;

import java.util.List;

public interface CategoriaDao {
    public void insert(Categoria categoria);
    public Integer updateById(Categoria categoria);
    public Integer deleteById(int id);
    Categoria findById(int id);
    List<Categoria> findAll();
}
