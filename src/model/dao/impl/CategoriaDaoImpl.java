package model.dao.impl;

import db.DB;
import exception.DBException;
import model.dao.CategoriaDao;
import model.entities.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        PreparedStatement preparedStatement = null;
        try{
            String sqlUpdateById = "Update categoria set nome = ? where id = ?";
            preparedStatement = connection.prepareStatement(sqlUpdateById);
            preparedStatement.setString(1,categoria.getNome());
            preparedStatement.setInt(2,categoria.getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
        }
    }

    @Override
    public Integer deleteById(int id) {
        PreparedStatement preparedStatement = null;
        findById(id);
        try{
            String sqlDeleteById = "Delete from categoria where id = ?";
            preparedStatement = connection.prepareStatement(sqlDeleteById);
            preparedStatement.setInt(1,id);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0){
                System.out.println("Delete completed : ");
                return rows;
            }else{
                throw new DBException("Don't found Id");
            }
        }catch (SQLException e){
            throw  new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
        }
    }

    @Override
    public Categoria findById(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            String sqlFindById = "Select * from categoria where id =?";
            preparedStatement = connection.prepareStatement(sqlFindById);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return getCategoria(resultSet);
            }else{
                throw new DBException("Don't found Category");
            }
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Categoria> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Categoria>allCategoria = new ArrayList<>();
        try{
            String sqlFindAll = "Select * from categoria";
            preparedStatement = connection.prepareStatement(sqlFindAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allCategoria.add(getCategoria(resultSet));
            }
            return allCategoria;

        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    private Categoria getCategoria(ResultSet resultSet){
        try{
            Categoria categoria = new Categoria();
            categoria.setId(resultSet.getInt("id"));
            categoria.setNome(resultSet.getString("nome"));

            return categoria;
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

}
