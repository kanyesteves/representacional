package br.sc.senac.mca.dao.impl;

import br.sc.senac.mca.dao.TesteDao;
import br.sc.senac.mca.model.Teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDaoJDBC implements TesteDao {
    Connection connection;

    public TesteDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insercao(Teste teste) {
        PreparedStatement st;
        try{
            st = connection.prepareStatement("insert into teste (digital, auditivo, cinestesico, visual)" +
                    "values(?, ?, ?, ?)");
            st.setInt(1, teste.getDigital());
            st.setInt(2, teste.getAuditivo());
            st.setInt(3, teste.getCinestesico());
            st.setInt(4, teste.getVisual());
            st.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
