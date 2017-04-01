package br.fatec.atividade07.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USR_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_ID")
	private Long id;

	@Column(name = "USR_NOME", unique = true, length = 20, nullable = false)
	private String nome;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CRT_ID", nullable = false)
	private Cartao cartao;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Artigo> artigos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(ArrayList<Artigo> artigos) {
		this.artigos = artigos;
	}

	public void addArtigo(Artigo artigo) {
		this.artigos.add(artigo);
		if (artigo.getOwner() != this) {
			artigo.setOwner(this);
		}
	}

}
