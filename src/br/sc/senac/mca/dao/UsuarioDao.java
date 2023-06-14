package br.sc.senac.mca.dao;

import br.sc.senac.mca.model.Usuario;

public interface UsuarioDao {
    public Usuario acharPorLoginESenha(String login, String senha);

    public Integer insercao(Usuario usuario);
}
