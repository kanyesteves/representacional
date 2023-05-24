package br.sc.senac.repre.aplicacao;


import br.sc.senac.repre.Util.ConnectionFactory;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConexao();
    }
}