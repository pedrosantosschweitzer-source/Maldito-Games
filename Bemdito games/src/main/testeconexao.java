package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class testeconexao {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/biblio"; 
        String user = "postgres";
        String password = "1234"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("CONECTOU NO BANCO!");
        } catch (Exception e) {
            System.out.println("ERRO AO CONECTAR:");
            e.printStackTrace();
        }

    }
}