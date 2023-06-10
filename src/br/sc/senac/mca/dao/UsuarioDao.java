package br.sc.senac.mca.dao;

import br.sc.senac.mca.model.Usuario;

public interface UsuarioDao {
    public Usuario acharPorId(Integer id);

    public boolean autenticacao(String login, String senha);

    public void insercao(Usuario usuario);
}
