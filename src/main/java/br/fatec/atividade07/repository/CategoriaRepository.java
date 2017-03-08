package br.fatec.atividade07.repository;

import org.springframework.data.repository.CrudRepository;

import br.fatec.atividade07.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
