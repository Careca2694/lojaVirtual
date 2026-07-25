package model.dao.impl;

import db.DB;
import exception.DBException;
import model.dao.CategoriaDao;
import model.entities.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDaoImpl implements CategoriaDao {

    private final Connection connection;

    public CategoriaDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Categoria categoria) {

        PreparedStatement preparedStatement = null;
        try{
            String sqlInsert = "insert into categoria(nome)value(?)";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,categoria.getNome());
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
        }

    }

    @Override
    public Integer updateById(Categoria categoria) {
        return 0;
    }

    @Override
    public Integer deleteById(int id) {
        return 0;
    }

    @Override
    public Categoria findById(int id) {
        return null;
    }

    @Override
    public List<Categoria> findAll() {
        return List.of();
    }
}
