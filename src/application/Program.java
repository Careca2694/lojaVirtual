package application;


import db.DB;
import model.dao.CategoriaDao;
import model.dao.ClientDao;
import model.dao.DaoFactory;
import model.dao.impl.CategoriaDaoImpl;
import model.entities.Categoria;
import model.entities.Client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public void main(String[] args){

         DB.getConnection();
//        CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
//        Categoria categoria = new Categoria(null,"Construcao");
//       // categoriaDao.insert(categoria);
//        Categoria newCategoria = categoriaDao.findById(5);
//       // int delteById = categoriaDao.deleteById(2);
//        newCategoria = categoriaDao.findById(5);
//        newCategoria.setNome("Mobilia");
//        categoriaDao.updateById(newCategoria);
//
//        System.out.println("Insercao completed : " + categoria);
//        System.out.println("Categoria encontrada : " + newCategoria);
//        //System.out.println("Delete completed : " + delteById);
//        System.out.println("Update completed : ");
//
//        List<Categoria> list;
//        list = categoriaDao.findAll();
//
//        for(Categoria ct : list){
//            System.out.println("All category: " + ct);
//        }

          ClientDao clientDao = DaoFactory.createClientDao();
//        Client client = new Client(null,"Ayden firmino",873885888,"Laulane",new Date());
//        clientDao.insert(client);
//        System.out.println("Cliente inserido com successo: ");

//        Client client = clientDao.findById(1);
//        System.out.println("Id encontrado : " + client);
//        Client newClient = new Client(1,"Felisberto",844093368,"Laulane",new Date());
//       clientDao.updateById(newClient);
//        System.out.println("Cliente atualizado com successo: " + newClient);
//        int id = clientDao.deleteById(1);
//        System.out.println("Deleted completed: " + id);
          List<Client>list;
          list = clientDao.findAll();

          for(Client cli : list){
              System.out.println("Todos cliente " + cli);
          }



        DB.closeConnection();
    }
}
