package br.fatec.atividade07.service;

import br.fatec.atividade07.model.Cartao;
import br.fatec.atividade07.model.Usuario;

public interface UsuarioService {

	public Usuario buscaPorId(Long id);

	public Usuario updateCartao(Long usuario_id, Cartao cartao);

	public void criaUsuario(Usuario usuario);
	public Usuario buscaPorNome(String nome);

}
