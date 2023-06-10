package br.sc.senac.mca.view;

import br.sc.senac.mca.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultadoView extends JFrame {
    private JPanel pnlResultado;
    private JButton btnDeslogar;
    private JLabel lblCinestesico;
    private JLabel lblCinestesicoFix;
    private JLabel lblVisual;
    private JLabel lblVisualFix;
    private JLabel lblDigital;
    private JLabel lblDigitalFix;
    private JLabel lblAuditivoFix;
    private JLabel lblAuditivo;
    private JLabel lblCursoFix;
    private JLabel lblCurso;
    private JLabel lblNomeFix;
    private JLabel lblNome;
    private JLabel lblDataNascimentoFix;
    private JLabel lblFaseFix;
    private JLabel lblDataNascimento;
    private JLabel lblFase;

    private Usuario usuario;

    public ResultadoView(Usuario usuario) {
        this.usuario = usuario;
        inicializar();
        todosComponentes();
        mostrarDados();
    }

    private void inicializar() {
        setVisible(true);
        setContentPane(pnlResultado);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Resultado");
        setSize(350, 145);
        setLocationRelativeTo(null);
    }

    private void todosComponentes() {
        btnDeslogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginView loginView = new LoginView();
            }
        });
    }

    private void mostrarDados() {
        lblNome.setText(usuario.getNome());
        lblFase.setText(String.valueOf(usuario.getFase()));
        lblCurso.setText(usuario.getCurso());
        lblDataNascimento.setText(String.valueOf(usuario.getNascimento()));
        lblDigital.setText(String.valueOf(usuario.getTeste().getDigital()) + "%");
        lblAuditivo.setText(String.valueOf(usuario.getTeste().getAuditivo()) + "%");
        lblCinestesico.setText(String.valueOf(usuario.getTeste().getCinestesico()) + "%");
        lblVisual.setText(String.valueOf(usuario.getTeste().getVisual()) + "%");
    }
}

