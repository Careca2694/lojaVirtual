package model.dao.impl;

import db.DB;
import exception.DBException;
import model.dao.ClientDao;
import model.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    private final Connection connection;

    public ClientDaoImpl(Connection connection){
        this.connection = connection;
    }


    @Override
    public void insert(Client client) {

        PreparedStatement preparedStatement = null;
        try{
            String sqlInsert = "Insert into cliente (nome,nascimento,morada,contacto)values(?,?,?,?) ";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,client.getName());
            preparedStatement.setDate(2,new java.sql.Date(client.getBirthDay().getTime()));
            preparedStatement.setString(3,client.getLocation());
            preparedStatement.setInt(4,client.getContact());

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
        }

    }

    @Override
    public Integer updateById(Client client) {

        PreparedStatement preparedStatement = null;
        findById(client.getId());

        try{
            String sqlUpdateById = "update cliente set nome = ?, nascimento = ?, morada = ?, contacto = ? where id = ?";
            preparedStatement = connection.prepareStatement(sqlUpdateById);

            preparedStatement.setString(1,client.getName());
            preparedStatement.setDate(2,new java.sql.Date(client.getBirthDay().getTime()));
            preparedStatement.setString(3,client.getLocation());
            preparedStatement.setInt(4,client.getContact());
            preparedStatement.setInt(5,client.getId());
            return preparedStatement.executeUpdate();

        }catch(SQLException e){
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
            String sqlDeleteById = "Delete from lojavirtual.cliente where id = ?";
            preparedStatement = connection.prepareStatement(sqlDeleteById);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatment(preparedStatement);
        }
    }

    @Override
    public Client findById(int id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            String sqlFindById = "Select * from cliente where id = ?";
            preparedStatement = connection.prepareStatement(sqlFindById);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return getCliente(resultSet);
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

    private Client getCliente(ResultSet resultSet) {
        try{
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("nome"));
            client.setContact(resultSet.getInt("contacto"));
            client.setLocation(resultSet.getString("morada"));
            client.setBirthDay(resultSet.getDate("nascimento"));
            return client;
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }
}
