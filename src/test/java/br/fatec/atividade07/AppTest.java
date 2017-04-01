package br.fatec.atividade07;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.fatec.atividade07.model.Artigo;
import br.fatec.atividade07.model.Cartao;
import br.fatec.atividade07.model.Usuario;
import br.fatec.atividade07.service.ArtigoService;
import br.fatec.atividade07.service.CartaoService;
import br.fatec.atividade07.service.CategoriaService;
import br.fatec.atividade07.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AppTest {

	@Autowired
	private ArtigoService artigoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private CartaoService cartaoService;

	@Test
	public void test() {

		// Cria cartao
		Long number = 15L;
		Cartao cartao = new Cartao();
		cartao.setNumero(number);
		cartaoService.createCartao(cartao);

		cartao = cartaoService.findByNumero(number);

		assertEquals(number, cartao.getNumero());

		// Cria Usuario
		String nome = "Sergio06";
		Usuario user = new Usuario();
		user.setCartao(cartao);
		user.setNome(nome);
		usuarioService.criaUsuario(user);

		user = usuarioService.buscaPorNome(nome);

		assertEquals(nome, user.getNome());

		// Cria artigos
		List<Artigo> artigos = new ArrayList<Artigo>();

		for (int i = 0; i < 10; ++i) {
			Artigo art = new Artigo();
			art.setDescricao(String.valueOf(i));
			art.setTitulo(String.valueOf(i));
			art.setOwner(user);
			artigoService.create(art);
			artigos.add(art);
		}
	}
}
