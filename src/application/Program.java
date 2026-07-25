package application;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import db.DB;
import model.dao.CategoriaDao;
import model.dao.DaoFactory;
import model.dao.impl.CategoriaDaoImpl;
import model.entities.Categoria;
import model.entities.Client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Program {

    public void main(String[] args){

         DB.getConnection();
        CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
        Categoria categoria = new Categoria(null,"Construcao");
       // categoriaDao.insert(categoria);
        Categoria newCategoria = categoriaDao.findById(5);
       // int delteById = categoriaDao.deleteById(2);
        newCategoria = categoriaDao.findById(5);
        newCategoria.setNome("Mobilia");
        categoriaDao.updateById(newCategoria);

        System.out.println("Insercao completed : " + categoria);
        System.out.println("Categoria encontrada : " + newCategoria);
        //System.out.println("Delete completed : " + delteById);
        System.out.println("Update completed : ");
        
        List<Categoria> list;
        list = categoriaDao.findAll();

        for(Categoria ct : list){
            System.out.println("All category: " + ct);
        }


        DB.closeConnection();
    }
}
