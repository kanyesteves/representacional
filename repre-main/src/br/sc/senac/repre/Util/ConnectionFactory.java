package br.sc.senac.repre.Util;

import javax.swing.*;
import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/representacional";
    private static final String USER = "root";
    private static final String PASSWORD = "root99"; //vai para o metod getConnection

    final static String CONSULTA = "select * from cliente";

    public static Connection getConexao() {
        Connection conexao = null; // inicializando o objeto conexao e atribuindo um valor nulo (tipo connection)

        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");
            Statement st = conexao.createStatement();
            System.out.println("Statment criado!");

            String query = "insert into cliente(cli_cod,cli_nome, cli_cpf, cli_dt_nasc) values (?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(query);

            String cli_cod = JOptionPane.showInputDialog("Digite o código do cliente");
            String cli_nome = JOptionPane.showInputDialog("Digite o nome do cliente");
            String cli_cpf = JOptionPane.showInputDialog("Insira o cpf do cliente");
            String cli_dt_nasc=  JOptionPane.showInputDialog("Insira a dataNascimento");

            stmt.setString(1, cli_cod);
            stmt.setString(2, cli_nome);
            stmt.setString(3, cli_cpf);
            stmt.setString(4, cli_dt_nasc);

            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Dados inseridos!");

            ResultSet resultSet = stmt.executeQuery(CONSULTA);

            while (resultSet.next()){
                System.out.println(resultSet.getString("cli_nome"));
                System.out.println(resultSet.getString("cpf"));
                System.out.println(resultSet.getString("dataNascimento"));
                System.out.println(resultSet.getString("fone"));
            }

            if (conexao != null) {
                System.out.println("Conexão estabelecida! ");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);// tratar com excecao SQL e dar nome de E que vai retornar uma mensagem p o usuario

        }
        return conexao;
    }
}