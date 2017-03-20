package br.fatec.atividade07;

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
import br.fatec.atividade07.service.CategoriaService;
import br.fatec.atividade07.service.UsuarioService;

public class AppTest {
	
	private ArtigoService artigoService;
	private CategoriaService categoriaService;
	private UsuarioService usuarioService;
	
	@Before
	public void setup(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		artigoService = (ArtigoService)context.getBean("artigoService");
		categoriaService = (CategoriaService)context.getBean("categoriaService");
		usuarioService = (UsuarioService)context.getBean("usuarioService");

	}
	
	@Test
	public void test() {
		
		//Cria cartao
		Cartao cartao = new Cartao();
		cartao.setNumero(12345567890L);
		
		//Cria artigos
		List<Artigo> artigos= new ArrayList<Artigo>();
		
		for(int i = 0; i < 10; ++i){
			Artigo art = new Artigo();
			art.setDescricao(String.valueOf(i));
			art.setTitulo(String.valueOf(i));
			artigos.add(art);
		}
		
		//Cria usuarios
		try {
			usuarioService.criaUsuario("Sergio", artigos, cartao);
		}
		catch(Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}
	}
}
