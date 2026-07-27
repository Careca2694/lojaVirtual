package application;


import db.DB;
import model.dao.CategoriaDao;
import model.dao.ClientDao;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.dao.impl.CategoriaDaoImpl;
import model.entities.Categoria;
import model.entities.Client;
import model.entities.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public void main(String[] args){

         DB.getConnection();
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        //Produto prod1 = new Produto(null,"nivea",15,490.50,3);
       // produtoDao.insert(prod1);
       // System.out.println("Produto inserido com successo." + prod1);
        Produto prod2 = produtoDao.findById(1);
        System.out.println("Produto com id: " + prod2 + " encontrado");

        Produto prod1 = new Produto(4,"sapatos",12,4490.50,3);
        produtoDao.updateById(prod1);
//        int del = produtoDao.deleteById(5);
//        System.out.println("Deleted completed." + del);

        List<Produto> allP;
        allP = produtoDao.findAll();

        for(Produto prods : allP){
            System.out.println("Todos produtos: " + prods);
        }


        DB.closeConnection();
    }
}
