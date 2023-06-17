package br.sc.senac.mca.dao.impl;

import java.sql.*;

import br.sc.senac.mca.dao.UsuarioDao;
import br.sc.senac.mca.model.Teste;
import br.sc.senac.mca.model.Usuario;
import br.sc.senac.mca.util.ConnectionFactory;

import javax.swing.*;

public class UsuarioDaoJDBC implements UsuarioDao {

    Connection conexao = null;

    public UsuarioDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public Usuario acharPorLoginESenha(String login, String senha) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conexao.prepareStatement("select usuario.id, usuario.nome, usuario.login, usuario.dataAniversario, usuario.curso, usuario.fase, usuario.senha, teste.id, teste.digital, teste.auditivo, teste.cinestesico, teste.visual from usuario "
                    + "inner join usuario_tem_teste on usuario.id = usuario_tem_teste.id_usuario inner join teste on teste.id = usuario_tem_teste.id_teste where usuario.login = ? and usuario.senha = ?;\r\n"
                    + "");
            st.setString(1, login);
            st.setString(2, senha);
            rs = st.executeQuery();
            if (rs.next()) {
                return criarUsuario(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.CloseResultSet(rs);
            ConnectionFactory.CloseStatement(st);
        }
        return null;
    }

    @Override
    public Integer insercao(Usuario usuario) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conexao.prepareStatement("insert into usuario(login, nome, dataAniversario, curso, fase, senha)"
                    + "values( ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getNome());
            st.setDate(3, new Date(usuario.getNascimento().getTime()));
            st.setString(4, usuario.getCurso());
            st.setInt(5, usuario.getFase());
            st.setString(6, usuario.getSenha());
            int row = st.executeUpdate();
            if (row > 0) {
                System.out.println("Cadastrado com sucesso!");
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.CloseResultSet(rs);
            ConnectionFactory.CloseStatement(st);
        }
        return null;
    }

    private Usuario criarUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("usuario.id"));
        usuario.setNome(rs.getString("usuario.nome"));
        usuario.setLogin(rs.getString("usuario.login"));
        usuario.setNascimento(rs.getDate("usuario.dataAniversario"));
        usuario.setCurso(rs.getString("usuario.curso"));
        usuario.setFase(rs.getInt("usuario.fase"));
        usuario.setSenha(rs.getString("usuario.senha"));
        Teste teste = criarTeste(rs);
        usuario.setTeste(teste);
        return usuario;
    }

    private Teste criarTeste(ResultSet rs) throws SQLException {
        Teste teste = new Teste();
        teste.setId(rs.getInt("teste.id"));
        teste.setDigital(rs.getInt("teste.digital"));
        teste.setAuditivo(rs.getInt("teste.auditivo"));
        teste.setCinestesico(rs.getInt("teste.cinestesico"));
        teste.setVisual(rs.getInt("teste.visual"));
        return teste;
    }
}