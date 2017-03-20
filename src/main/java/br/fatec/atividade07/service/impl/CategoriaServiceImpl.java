package br.fatec.atividade07.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.atividade07.model.Categoria;
import br.fatec.atividade07.repository.CategoriaRepository;
import br.fatec.atividade07.service.CategoriaService;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriarepository;


	public Categoria getCategoryById(Long id) {
		return categoriarepository.findById(id);
	}


	public CategoriaRepository getCategoriarepository() {
		return categoriarepository;
	}


	public void setCategoriarepository(CategoriaRepository categoriarepository) {
		this.categoriarepository = categoriarepository;
	}
	
	

}
