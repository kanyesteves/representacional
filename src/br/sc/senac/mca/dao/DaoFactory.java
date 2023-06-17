package br.sc.senac.mca.dao;

import br.sc.senac.mca.dao.impl.TesteDaoJDBC;
import br.sc.senac.mca.dao.impl.UsuarioDaoJDBC;
import br.sc.senac.mca.dao.impl.UsuarioTemTesteJDBC;
import br.sc.senac.mca.util.ConnectionFactory;

public class DaoFactory {
    public static UsuarioDao createUsuarioDao() {
        return new UsuarioDaoJDBC(ConnectionFactory.getConexao());
    }

    public static TesteDao createTesteDao() {
        return new TesteDaoJDBC(ConnectionFactory.getConexao());
    }
    public static UsuarioTemTesteDao createUsuarioTemTesteDao(){
        return new UsuarioTemTesteJDBC(ConnectionFactory.getConexao());
    }
}
