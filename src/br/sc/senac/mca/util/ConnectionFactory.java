package br.sc.senac.mca.util;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/gerenciamento";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; //
    private static Connection conexao;

    private ConnectionFactory() {
    }

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);// tratar com excecao SQL e dar nome de E que vai retornar uma mensagem p o usuario
        }
        return conexao;
    }
    public static void closeConnection(){
        if(conexao != null){
            try{
                conexao.close();
                System.out.println("Fechado");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void CloseResultSet(ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void CloseStatement(PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try{
                preparedStatement.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
