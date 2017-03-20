package br.fatec.atividade07.service;

import java.util.List;

import br.fatec.atividade07.model.Artigo;
import br.fatec.atividade07.model.Cartao;
import br.fatec.atividade07.model.Categoria;
import br.fatec.atividade07.model.Usuario;

public interface UsuarioService {
	
	public Usuario buscaPorId(Long id);
	public Usuario updateCartao(Long usuario_id, Cartao cartao);
	public void criaUsuario(String nome, List<Artigo> artigos, Cartao cartao);
	public List<Artigo> buscaArtigos(Long usuario_id);
	public void updateArtigos(Usuario usuario, List<Artigo> artigos);
	public boolean artigoPertenceAoUsuario(Usuario usuario, Artigo artigo);
	public List<Artigo> buscaCategoriaArtigos(Usuario usuario, Categoria categoria); 
	
}
