package br.sc.senac.mca.dao.impl;

import br.sc.senac.mca.dao.TesteDao;
import br.sc.senac.mca.model.Teste;

import java.sql.*;

public class TesteDaoJDBC implements TesteDao {
    Connection connection;

    public TesteDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Integer insercao(Teste teste) {
        PreparedStatement st;
        try {
            st = connection.prepareStatement("insert into teste (digital, auditivo, cinestesico, visual)" +
                    "values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, teste.getDigital());
            st.setInt(2, teste.getAuditivo());
            st.setInt(3, teste.getCinestesico());
            st.setInt(4, teste.getVisual());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
