package br.fatec.atividade07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.fatec.atividade07.model.CategoriaArtigo;

public interface CategoriaArtigoRepository extends CrudRepository<CategoriaArtigo, Long> {

	@Query("select u from CategoriaArtigo u where u.artId = :article_id and u.catId = :cat_id")
	public CategoriaArtigo articleBelongsToCat(@Param("article_id")Long article_id, @Param("cat_id")Long cat_id);
	
	@Query("select u from CategoriaArtigo u where u.catId = :cat_id")
	public List<CategoriaArtigo> getAllArticlesByCategory(@Param("cat_id")Long cat_id);
}
