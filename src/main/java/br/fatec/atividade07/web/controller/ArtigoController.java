package br.fatec.atividade07.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.fatec.atividade07.model.Artigo;
import br.fatec.atividade07.service.ArtigoService;
import br.fatec.atividade07.view.View;

@RestController
@RequestMapping(value = "/usuario")
public class ArtigoController {

	@Autowired
	private ArtigoService artigoService;

	public ArtigoService getArtigoService() {
		return artigoService;
	}

	public void setArtigoService(ArtigoService artigoService) {
		this.artigoService = artigoService;
	}

	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Artigo> get(@RequestParam(value = "id", defaultValue = "1") Long id) {
		Artigo artigo = artigoService.buscaPorId(id);
		if (artigo == null) {
			return new ResponseEntity<Artigo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Artigo>(artigo, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll")
	@JsonView(View.Alternative.class)
	public ResponseEntity<Collection<Artigo>> getAll() {
		return new ResponseEntity<Collection<Artigo>>(artigoService.getArtigos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Artigo save(@RequestBody Artigo artigo, HttpServletRequest request, HttpServletResponse response) {
		artigoService.create(artigo);
		artigo = artigoService.buscaPorTitulo(artigo.getTitulo());
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/usuario/getById?id=" + artigo.getId());
		return artigo;
	}

}
