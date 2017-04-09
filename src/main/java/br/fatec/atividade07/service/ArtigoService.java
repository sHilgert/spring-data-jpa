package br.fatec.atividade07.service;

import java.util.List;

import br.fatec.atividade07.model.Artigo;

public interface ArtigoService {

	public List<Artigo> getArtigos();

	public boolean artigoPertenceCategoria(Long artigo_id, Long categoria_id);

	public Artigo buscaPorId(Long id);

	public List<Artigo> artigosPertencentesCategoria(Long categoria);

	public void create(Artigo art);

	public void create(List<Artigo> art);

	public Artigo buscaPorTitulo(String titulo);
}
