package br.fatec.atividade07.repository;

import org.springframework.data.repository.CrudRepository;

import br.fatec.atividade07.model.Artigo;

public interface ArtigoRepository extends CrudRepository<Artigo, Long> {

	public Artigo findById(Long id);

	public Artigo findByTitulo(String titulo);
}
