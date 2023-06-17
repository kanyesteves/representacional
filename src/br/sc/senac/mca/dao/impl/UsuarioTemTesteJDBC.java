package br.sc.senac.mca.dao.impl;

import br.sc.senac.mca.dao.UsuarioTemTesteDao;
import br.sc.senac.mca.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioTemTesteJDBC implements UsuarioTemTesteDao {
    private Connection conexao;

    public UsuarioTemTesteJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void vincularUsuarioTeste(Integer usuario, Integer teste) {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement("Insert into usuario_tem_teste(id_usuario, id_teste) values (?,?)");
            st.setInt(1, usuario);
            st.setInt(2, teste);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.CloseStatement(st);
        }

    }
}
