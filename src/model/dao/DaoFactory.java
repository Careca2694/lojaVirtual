package model.dao;

import db.DB;
import model.dao.impl.CategoriaDaoImpl;
import model.dao.impl.ClientDaoImpl;
import model.dao.impl.ProdutoDaoImpl;
import model.entities.Produto;

import java.util.List;

public class DaoFactory {

    public static ProdutoDao createProdutoDao(){
        return new ProdutoDaoImpl(DB.getConnection());
    }

    public static ClientDao createClientDao(){
        return new ClientDaoImpl(DB.getConnection());
    }

    public static CategoriaDao createCategoriaDao(){
        return new CategoriaDaoImpl(DB.getConnection());
    }

}
