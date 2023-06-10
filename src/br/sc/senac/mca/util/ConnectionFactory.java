package br.sc.senac.mca.util;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/gerenciamento";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; //vai para o metod getConnection

    private static Connection conexao;

    private ConnectionFactory() {
    }

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão estabelecida! ");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);// tratar com excecao SQL e dar nome de E que vai retornar uma mensagem p o usuario
        }
        return conexao;
    }
    public static void closeConnection(Connection connection){

    }

    public static void CloseResultSet(ResultSet resultSet){

    }
}
