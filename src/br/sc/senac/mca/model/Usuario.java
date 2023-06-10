package br.sc.senac.mca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String login;
    private String nome;
    private Date nascimento;
    private String curso;
    private Integer fase;
    private String senha;
    private Teste teste;

    public Usuario() {

    }

    public Usuario(String nome, String login, Date nascimento, String curso, Integer fase, String senha) {

        this.nome = nome;
        this.login = login;
        this.nascimento = nascimento;
        this.curso = curso;
        this.fase = fase;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getFase() {
        return fase;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", login=" + login + ", nome=" + nome + ", nascimento=" + nascimento + ", curso="
                + curso + ", fase=" + fase + ", senha=" + senha + ", teste=" + teste + "]";
    }

}
