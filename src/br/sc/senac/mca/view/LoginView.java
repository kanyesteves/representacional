package br.sc.senac.mca.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel pnlLogin;
    private JButton btnSair;
    private JButton btnRegistrar;
    private JButton btnLogin;
    private JTextField txtSenha;
    private JTextField txtLogin;
    private JLabel lblLogin;
    private JLabel lblSenha;

    public LoginView() {
        todosComponentes();
        inicializar();
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
                dispose();

            }
        });
    }


}
