package br.fatec.atividade07.repository;

import org.springframework.data.repository.CrudRepository;

import br.fatec.atividade07.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findById(Long id);

	// @Query("select u from Usuario u where u.nome = :nome_usuario")
	// public Usurio findByName(@Param("nome_usuario")String nome);

	public Usuario findByNome(String name);

}
