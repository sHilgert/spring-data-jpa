package br.fatec.atividade07.repository;

import org.springframework.data.repository.CrudRepository;

import br.fatec.atividade07.model.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {

}
