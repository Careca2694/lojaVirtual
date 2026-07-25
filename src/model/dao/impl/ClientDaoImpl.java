package model.dao.impl;

import model.dao.ClientDao;
import model.entities.Client;

import java.sql.Connection;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    private final Connection connection;

    public ClientDaoImpl(Connection connection){
        this.connection = connection;
    }


    @Override
    public void insert(Client client) {

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
