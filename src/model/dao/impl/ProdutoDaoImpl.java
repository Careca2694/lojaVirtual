package model.dao.impl;

import db.DB;
import exception.DBException;
import model.dao.ProdutoDao;
import model.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDaoImpl implements ProdutoDao {

    private final Connection connection;

    public ProdutoDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Produto produto) {
        PreparedStatement preparedStatement = null;
        try{
            String sqlInsert = "Insert into lojavirtual.produto(nome,quantidade,preco,categoriaId)values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,produto.getName());
            preparedStatement.setInt(2,produto.getQuantity());
            preparedStatement.setDouble(3,produto.getPrice());
            preparedStatement.setInt(4,produto.getCategory());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
        }

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
     PreparedStatement preparedStatement = null;
     ResultSet resultSet = null;
     try{
         String sqlFindById = "Select * from produto where id =?";
         preparedStatement = connection.prepareStatement(sqlFindById);
         preparedStatement.setInt(1,id);
         resultSet = preparedStatement.executeQuery();
         if(resultSet.next()){
           return getProdutos(resultSet);
         }else{
             throw new DBException("Don't found id");
         }

     }catch (SQLException e){
         throw new DBException(e.getMessage());
     }finally {
         DB.closeStatment(preparedStatement);
         DB.closeResultSet(resultSet);
     }
    }

    private Produto getProdutos(ResultSet resultSet){
        Produto produto = new Produto();
        try{
            produto.setId(resultSet.getInt("id"));
            produto.setName(resultSet.getString("nome"));
            produto.setQuantity(resultSet.getInt("quantidade"));
            produto.setPrice(resultSet.getDouble("preco"));
            produto.setCategory(resultSet.getInt("categoriaId"));

            return produto;
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }


    @Override
    public List<Produto> findAll() {
        return List.of();
    }
}
