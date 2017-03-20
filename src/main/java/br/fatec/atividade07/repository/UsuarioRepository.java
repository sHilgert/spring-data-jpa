package br.fatec.atividade07.repository;

import org.springframework.data.repository.CrudRepository;

import br.fatec.atividade07.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	public Usuario findById(Long id);
}
