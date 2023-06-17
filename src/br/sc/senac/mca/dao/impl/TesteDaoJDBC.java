package br.sc.senac.mca.dao.impl;

import br.sc.senac.mca.dao.TesteDao;
import br.sc.senac.mca.model.Teste;
import br.sc.senac.mca.util.ConnectionFactory;

import java.sql.*;

public class TesteDaoJDBC implements TesteDao {
    Connection conexao;

    public TesteDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public Integer insercao(Teste teste) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conexao.prepareStatement("insert into teste (digital, auditivo, cinestesico, visual)" +
                    "values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, teste.getDigital());
            st.setInt(2, teste.getAuditivo());
            st.setInt(3, teste.getCinestesico());
            st.setInt(4, teste.getVisual());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionFactory.CloseResultSet(rs);
            ConnectionFactory.CloseStatement(st);
        }
        return null;
    }
}
