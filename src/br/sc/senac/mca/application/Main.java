package br.sc.senac.mca.application;

import java.sql.Connection;
import java.sql.Date;

import br.sc.senac.mca.dao.DaoFactory;
import br.sc.senac.mca.dao.UsuarioDao;
import br.sc.senac.mca.model.Teste;
import br.sc.senac.mca.model.Usuario;
import br.sc.senac.mca.util.ConnectionFactory;
import br.sc.senac.mca.view.LoginView;

public class Main {
    public static void main(String[]args){
        LoginView loginView = new LoginView();
    }
}