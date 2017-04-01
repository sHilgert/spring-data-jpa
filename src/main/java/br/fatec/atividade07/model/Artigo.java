package br.fatec.atividade07.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ART_ARTIGO")
public class Artigo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ART_ID")
	private Long id;

	@Column(name = "ART_TITULO", length = 50, nullable = false)
	private String titulo;

	@Column(name = "ART_DESCRICAO", length = 200, nullable = false)
	private String descricao;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CATEGORIA_ARTIGO", joinColumns = { @JoinColumn(name = "ART_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CAT_ID") })
	private List<Categoria> categorias;

	@ManyToOne
	@JoinColumn(name = "USR_ID")
	private Usuario owner;

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
		if (!owner.getArtigos().contains(this)) {
			owner.getArtigos().add(this);
		}
	}

}
