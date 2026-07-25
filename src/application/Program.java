package application;

import db.DB;
import model.entities.Client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public void main(String[] args){

//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Insert id Client: ");
//        int id = sc.nextInt();
//
//        System.out.print("Insert Name Client: ");
//        String name = sc.next();
//
//        System.out.print("Insert location Client: ");
//        String location = sc.next();
//
//        System.out.print("Insert contact Client: ");
//        int contact = sc.nextInt();
//
//        System.out.print("Insert BirthDay Client: ");
//        String data = sc.next();
//
//        LocalDate dateFormat = LocalDate.parse(data,fmt);
//
//        Client client = new Client(id,name,contact,location,dateFormat);
//
//        System.out.println("Client info: " + client);

         DB.getConnection();

    }
}
