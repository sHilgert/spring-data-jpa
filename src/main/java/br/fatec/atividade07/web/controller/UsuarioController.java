package br.fatec.atividade07.web.controller;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import br.fatec.atividade07.model.Usuario;
import br.fatec.atividade07.service.UsuarioService;
import br.fatec.atividade07.view.View;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value = "/get/{nome}")
	@JsonView(View.All.class)
	public ResponseEntity<Usuario> pesquisar(@PathVariable("nome") String nome) {
		return new ResponseEntity<Usuario>(usuarioService.buscaPorNome(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Usuario> get(@RequestParam(value = "id", defaultValue = "1") Long id) {
		Usuario usuario = usuarioService.buscaPorId(id);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll")
	@JsonView(View.Alternative.class)
	public ResponseEntity<Collection<Usuario>> getAll() {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.todos(), HttpStatus.OK);
	}

	// Voce pode informar o metodo e o tipo de retorno produzido
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	// E possivel indicar o status por anotacao, mas sera fixo, sem
	// possibilidade de tratar erros
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
		usuarioService.criaUsuario(usuario);
		usuario = usuarioService.buscaPorNome(usuario.getNome());
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
		return usuario;
	}

}
