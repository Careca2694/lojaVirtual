package application;

import db.DB;
import model.dao.CategoriaDao;
import model.dao.DaoFactory;
import model.dao.impl.CategoriaDaoImpl;
import model.entities.Categoria;
import model.entities.Client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public void main(String[] args){

         DB.getConnection();
        CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
        Categoria categoria = new Categoria(null,"Construcao");
       // categoriaDao.insert(categoria);
        Categoria FindById = categoriaDao.findById(5);
        int delteById = categoriaDao.deleteById(2);

        System.out.println("Insercao completed : " + categoria);
        System.out.println("Categoria encontrada : " + FindById);
        System.out.println("Delete completed : " + delteById);

        DB.closeConnection();
    }
}
