package br.fatec.atividade07.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fatec.atividade07.model.Artigo;
import br.fatec.atividade07.model.CategoriaArtigo;
import br.fatec.atividade07.repository.ArtigoRepository;
import br.fatec.atividade07.repository.CategoriaArtigoRepository;
import br.fatec.atividade07.service.ArtigoService;

@Service("artigoService")
public class ArtigoServiceImpl implements ArtigoService {

	@Autowired
	private ArtigoRepository artigoRepository;
	
	@Autowired
	private CategoriaArtigoRepository categoriaArtigoRepository;
	
	
	public List<Artigo> getArtigos() {
		List<Artigo> artigos = (ArrayList<Artigo>) artigoRepository.findAll();		
		return artigos;
	}

	public boolean artigoPertenceCategoria(Long artigo_id, Long categoria_id) {
		CategoriaArtigo artigoCat = (CategoriaArtigo) categoriaArtigoRepository.articleBelongsToCat(artigo_id, categoria_id);
		if(artigoCat == null)
			return false;
		return true;
	}

	public Artigo buscaPorId(Long id) {
		return artigoRepository.findById(id);
	}

	public List<Artigo> artigosPertencentesCategoria(Long categoria_id) {
		List<CategoriaArtigo> categoriaArtigos = (List<CategoriaArtigo>) categoriaArtigoRepository.getAllArticlesByCategory(categoria_id);
		List<Artigo> artigos = new ArrayList<Artigo>();
		for(CategoriaArtigo catArt: categoriaArtigos){
			artigos.add(buscaPorId(catArt.getArtId()));
		}
		
		return artigos; 
	}
	
	@Transactional
	public void createArtigo(Artigo artigo){
		artigoRepository.save(artigo);
	}

}
