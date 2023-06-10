package br.sc.senac.mca.view;

import br.sc.senac.mca.dao.DaoFactory;
import br.sc.senac.mca.dao.UsuarioDao;
import br.sc.senac.mca.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class CadastroView extends JFrame {
    private JPanel pnlCadastro;
    private JTextField txtLogin;
    private JTextField txtDataNascimento;
    private JTextField txtCurso;
    private JButton btnCadastrar;
    private JTextField txtNome;
    private JComboBox cbxFase;
    private JLabel lblLogin;
    private JLabel lblDataNascimento;
    private JLabel lblCurso;
    private JLabel lblFase;
    private JLabel lblCadastro;
    private JLabel lblNome;
    private JPasswordField pswSenha;
    private JLabel lblSenha;

    private UsuarioDao usuarioDao;

    public CadastroView() {
        initializer();
        allComponents();
        this.usuarioDao = DaoFactory.createUsuarioDao();
    }

    private void initializer() {
        setVisible(true);
        setSize(300, 210);
        setTitle("Cadastro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pnlCadastro);
        setLocationRelativeTo(null);
    }

    private void allComponents() {
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario usuario = CriarUsuario();
                    FormularioView formView = new FormularioView(usuario);
                    dispose();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    private Usuario CriarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(txtNome.getText());
        usuario.setLogin(txtLogin.getText());
        usuario.setNascimento(Date.valueOf(txtDataNascimento.getText()));
        usuario.setCurso(txtCurso.getText());
        usuario.setFase(Integer.parseInt(String.valueOf(cbxFase.getSelectedItem())));
        usuario.setSenha(pswSenha.getText());
        return usuario;
    }
}
