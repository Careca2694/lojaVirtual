package model.dao.impl;

import java.util.List;

public interface CategoriaDao {
    public void insert(CategoriaDao categoria);
    public Integer updateById(CategoriaDao categoria);
    public Integer deleteById(int id);
    CategoriaDao findById(int id);
    List<CategoriaDao> findAll();
}
