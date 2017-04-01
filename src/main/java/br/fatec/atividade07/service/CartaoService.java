package br.fatec.atividade07.service;

import br.fatec.atividade07.model.Cartao;

public interface CartaoService {

	public void createCartao(Cartao cartao);
	public Cartao findById(Long id);
	public Cartao findByNumero(Long id);
}
