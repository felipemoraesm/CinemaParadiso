package com.meuprojeto.cinemaparadiso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        System.out.println("Tentando conectar ao banco de dados...");
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }
}