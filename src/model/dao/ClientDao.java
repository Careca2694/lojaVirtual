package model.dao;

import model.entities.Client;

import java.util.List;

public interface ClientDao {

    public void insert(Client client);
    public Integer updateById(Client client);
    public Integer deleteById(int id);
    Client findById(int id);
    List<Client> findAll();

}
