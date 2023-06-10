package br.sc.senac.mca.view;

import br.sc.senac.mca.dao.DaoFactory;
import br.sc.senac.mca.dao.UsuarioDao;
import br.sc.senac.mca.model.Teste;
import br.sc.senac.mca.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioView extends JFrame {
    private JComboBox cbxQuestionC_1;
    private JPanel pnlFormulario;
    private JButton btnEnviar;
    private JComboBox cbxQuestionA_1;
    private JComboBox cbxQuestionV_1;
    private JComboBox cbxQuestionD_1;
    private JComboBox cbxQuestionA_2;
    private JComboBox cbxQuestionV_2;
    private JComboBox cbxQuestionD_2;
    private JComboBox cbxQuestionC_2;
    private JComboBox cbxQuestionV_3;
    private JComboBox cbxQuestionC_3;
    private JComboBox cbxQuestionD_3;
    private JComboBox cbxQuestionA_3;
    private JComboBox cbxQuestionA_4;
    private JComboBox cbxQuestionD_4;
    private JComboBox cbxQuestionC_4;
    private JComboBox cbxQuestionV_4;
    private JComboBox cbxQuestionA_5;
    private JComboBox cbxQuestionD_5;
    private JComboBox cbxQuestionC_5;
    private JComboBox cbxQuestionV_5;
    private Usuario usuario;
    private UsuarioDao usuarioDao;

    public FormularioView(Usuario usuario) {
        this.usuario = usuario;
        todosComponentes();
        inicializar();
        this.usuarioDao = DaoFactory.createUsuarioDao();

    }

    public void inicializar() {
        setTitle("Formulário");
        setVisible(true);
        setSize(600, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pnlFormulario);
        setLocationRelativeTo(null);
        pack();
    }

    public void todosComponentes() {
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setTeste(criarTeste());
                JOptionPane.showMessageDialog(null, "Enviado com sucesso");
                usuarioDao.insercao(usuario);
                ResultadoView resultView = new ResultadoView(usuario);
                dispose();

            }
        });
    }

    private Integer SomarResultado(Integer valor1, Integer valor2, Integer valor3, Integer valor4, Integer valor5) {
        return (valor1 + valor2 + valor3 + valor4 + valor5) * 2;
    }

    private Teste criarTeste() {
        Integer digital = SomarResultado(Integer.parseInt(String.valueOf(cbxQuestionD_1.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionD_2.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionD_3.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionD_4.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionD_5.getSelectedItem())));

        Integer auditivo = SomarResultado(Integer.parseInt(String.valueOf(cbxQuestionA_1.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionA_2.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionA_3.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionA_4.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionA_5.getSelectedItem())));

        Integer cinestesico = SomarResultado(Integer.parseInt(String.valueOf(cbxQuestionC_1.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionC_2.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionC_3.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionC_4.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionC_5.getSelectedItem())));

        Integer visual = SomarResultado(Integer.parseInt(String.valueOf(cbxQuestionV_1.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionV_2.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionV_3.getSelectedItem())),
                Integer.parseInt(String.valueOf(cbxQuestionV_4.getSelectedItem())), Integer.parseInt(String.valueOf(cbxQuestionV_5.getSelectedItem())));

        return new Teste(digital, auditivo, cinestesico, visual);
    }
}
