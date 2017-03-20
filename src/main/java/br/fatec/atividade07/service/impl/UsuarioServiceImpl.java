package br.fatec.atividade07.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.fatec.atividade07.model.Artigo;
import br.fatec.atividade07.model.Cartao;
import br.fatec.atividade07.model.Categoria;
import br.fatec.atividade07.model.Usuario;
import br.fatec.atividade07.repository.ArtigoRepository;
import br.fatec.atividade07.repository.CartaoRepository;
import br.fatec.atividade07.repository.UsuarioRepository;
import br.fatec.atividade07.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

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

	public List<Artigo> buscaArtigos(Long usuario_id) {
		Usuario usuario = usuarioRepository.findById(usuario_id);
		
		return usuario.getArtigos();
	}

	@Transactional
	public void updateArtigos(Usuario usuario, List<Artigo> artigos) {
		Usuario u = usuarioRepository.findById(usuario.getId());
		u.setArtigos(artigos);
		usuarioRepository.save(u);
	}

	public boolean artigoPertenceAoUsuario(Usuario usuario, Artigo artigo) {
		Usuario u = usuarioRepository.findById(usuario.getId());
		for(Artigo art: u.getArtigos()){
			if(art.getId() == artigo.getId())
				return true;
		}
		return false;
	}

	public List<Artigo> buscaCategoriaArtigos(Usuario usuario, Categoria categoria) {
		Usuario u = usuarioRepository.findById(usuario.getId());
		List<Artigo> artCats = new ArrayList<Artigo>();
		for(Artigo art: usuario.getArtigos()){
			for(Categoria artCat: art.getCategorias()){
				if(artCat.getId() == categoria.getId()){
					artCats.add(art);
					break;
				}
			}
		}
		return artCats;
	}
	
	@Transactional
	public void criaUsuario(String nome, List<Artigo> artigos, Cartao cartao){
		cartaoRepository.save(cartao);
		
		for(Artigo art: artigos){
			artigoRepository.save(art);
		}
		
		Usuario u = new Usuario();
		u.setArtigos(artigos);
		u.setCartao(cartao);
		u.setNome(nome);
		usuarioRepository.save(u);
	}

}
