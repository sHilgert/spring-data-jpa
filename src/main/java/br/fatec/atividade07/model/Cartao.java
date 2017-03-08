package br.fatec.atividade07.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRT_CARTAO")
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CRT_ID")
	private Long id;

	@Column(name = "CRT_NUMERO", unique = true, length = 20, nullable = false)
	private Long numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
}
