package br.fatec.atividade07;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.fatec.atividade07.model.Artigo;
import br.fatec.atividade07.model.Cartao;
import br.fatec.atividade07.model.Usuario;
import br.fatec.atividade07.service.ArtigoService;
import br.fatec.atividade07.service.CartaoService;
import br.fatec.atividade07.service.CategoriaService;
import br.fatec.atividade07.service.UsuarioService;

public class AppTest {

	private ArtigoService artigoService;
	private CategoriaService categoriaService;
	private UsuarioService usuarioService;
	private CartaoService cartaoService;

	@Before
	public void setup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		artigoService = (ArtigoService) context.getBean("artigoService");
		categoriaService = (CategoriaService) context.getBean("categoriaService");
		usuarioService = (UsuarioService) context.getBean("usuarioService");
		cartaoService = (CartaoService) context.getBean("cartaoService");
	}

	@Test
	public void test() {

		// Cria cartao
		Long number = 14L;
		Cartao cartao = new Cartao();
		cartao.setNumero(number);
		cartaoService.createCartao(cartao);
		cartao = cartaoService.findByNumero(number);
		assertEquals(number, cartao.getNumero());

		// Cria Usuario
		String nome = "Sergio05";
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
