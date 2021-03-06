package br.fatec.atividade07.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CATEGORIA_ARTIGO")
public class CategoriaArtigo {

	@Id
	private Long id;
	
	@Column(name = "CAT_ID")
	private Long catId;

	@Column(name = "ART_ID")
	private Long artId;

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public Long getArtId() {
		return artId;
	}

	public void setArtId(Long artId) {
		this.artId = artId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
