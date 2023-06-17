package br.sc.senac.mca.view;

import br.sc.senac.mca.dao.DaoFactory;
import br.sc.senac.mca.dao.UsuarioDao;
import br.sc.senac.mca.model.Usuario;
import br.sc.senac.mca.util.ConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel pnlLogin;
    private JButton btnSair;
    private JButton btnRegistrar;
    private JButton btnLogin;
    private JTextField txtLogin;
    private JLabel lblLogin;
    private JLabel lblSenha;
    private JPasswordField pwdSenha;
    private UsuarioDao usuarioDao;

    public LoginView() {
        todosComponentes();
        inicializar();
        usuarioDao = DaoFactory.createUsuarioDao();
    }

    private void inicializar() {
        setContentPane(pnlLogin);
        setTitle("Login");
        setVisible(true);
        setMinimumSize(new Dimension(400, 120));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void todosComponentes() {
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConnectionFactory.closeConnection();
            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CadastroView cadastroView = new CadastroView();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = usuarioDao.acharPorLoginESenha(txtLogin.getText(), pwdSenha.getText());
                if (usuario != null) {
                    ResultadoView resultadoView = new ResultadoView(usuario);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
                }
            }
        });
    }


}
