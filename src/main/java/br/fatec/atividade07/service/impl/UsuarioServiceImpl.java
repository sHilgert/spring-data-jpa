package br.fatec.atividade07.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fatec.atividade07.model.Cartao;
import br.fatec.atividade07.model.Usuario;
import br.fatec.atividade07.repository.ArtigoRepository;
import br.fatec.atividade07.repository.CartaoRepository;
import br.fatec.atividade07.repository.UsuarioRepository;
import br.fatec.atividade07.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private ArtigoRepository artigoRepository;

	public Usuario buscaPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	@Transactional
	public Usuario updateCartao(Long usuario_id, Cartao cartao) {
		Usuario usuario = usuarioRepository.findById(usuario_id);
		usuario.setCartao(cartao);
		usuarioRepository.save(usuario);
		return usuarioRepository.findById(usuario.getId());
	}

	@Transactional
	public void criaUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	@Transactional
	public Usuario buscaPorNome(String nome) {
		return (Usuario) usuarioRepository.findByNome(nome);
	}

	@Transactional
	public List<Usuario> todos() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

}
