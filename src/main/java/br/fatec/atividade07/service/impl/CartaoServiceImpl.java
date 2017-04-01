package br.fatec.atividade07.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fatec.atividade07.model.Cartao;
import br.fatec.atividade07.repository.CartaoRepository;
import br.fatec.atividade07.service.CartaoService;

@Service("cartaoService")
public class CartaoServiceImpl implements CartaoService{


	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Override
	@Transactional
	public void createCartao(Cartao cartao) {
		cartaoRepository.save(cartao);
		
	}
	
	@Override
	@Transactional
	public Cartao findById(Long id) {
		return (Cartao) cartaoRepository.findOne(id);
		
	}

	@Override
	public Cartao findByNumero(Long id) {
		return (Cartao) cartaoRepository.findByNumero(id);
	}
	
	

}
