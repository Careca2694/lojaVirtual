package model.dao.impl;

import db.DB;
import exception.DBException;
import model.dao.ClientDao;
import model.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return 0;
    }

    @Override
    public Integer deleteById(int id) {
        return 0;
    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }
}
