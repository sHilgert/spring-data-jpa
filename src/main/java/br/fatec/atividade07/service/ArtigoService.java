package br.fatec.atividade07.service;

import java.util.List;

import br.fatec.atividade07.model.Artigo;
import br.fatec.atividade07.model.Categoria;

public interface ArtigoService {

	public List<Artigo> getArtigos();
	public boolean artigoPertenceCategoria(Long artigo_id, Categoria categoria);
	public Artigo buscaPorId(Long id);
	public List<Artigo> artigosPertencentesCategoria(Categoria categoria);
	
}
