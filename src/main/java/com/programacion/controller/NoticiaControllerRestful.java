package com.programacion.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.service.INoticiaService;
import com.programacion.service.to.NoticiaTO;

@RestController
@RequestMapping("/noticias")
@CrossOrigin
public class NoticiaControllerRestful {

	@Autowired
	private INoticiaService noticiaService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void guardar(@RequestBody NoticiaTO noticia) {
		noticia.setFecha(LocalDateTime.now());
		this.noticiaService.guardar(noticia);
	}

	@GetMapping(path = "/{tituloCorto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NoticiaTO> buscar(@PathVariable String tituloCorto) {
		return ResponseEntity.status(HttpStatus.OK).body(this.noticiaService.buscar(tituloCorto));
	}

	@PutMapping(path = "/{tituloCorto}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody NoticiaTO noticia, @PathVariable String tituloCorto) {
		NoticiaTO noti = this.noticiaService.buscar(tituloCorto);
		noticia.setId(noti.getId());
		noticia.setTituloCorto(tituloCorto);
		noticia.setFecha(LocalDateTime.now());
		this.noticiaService.actualizar(noticia);
	}

	@DeleteMapping(path = "{tituloCorto}")
	@ResponseStatus(HttpStatus.OK)
	public void borrar(@PathVariable String tituloCorto) {
		this.noticiaService.borrar(tituloCorto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NoticiaTO>> consultaPorCedulaEst(@RequestParam String cedula) {
		return ResponseEntity.status(HttpStatus.OK).body(this.noticiaService.consultaPorCedulaEst(cedula));
	}

//	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<NoticiaTO>> consultarTodos() {
//		return ResponseEntity.status(HttpStatus.OK).body(this.noticiaService.consultarTodos());
//	}

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NoticiaTO>> consultarTodos() {
		List<NoticiaTO> lista = this.noticiaService.consultarTodos();
		for (NoticiaTO n : lista) {
			Link myLink = linkTo(methodOn(NoticiaControllerRestful.class).buscar(n.getTituloCorto())).withSelfRel();
			n.add(myLink);
		}

		return new ResponseEntity<>(lista, null, HttpStatus.OK);

		// return
		// ResponseEntity.status(HttpStatus.OK).body(this.noticiaService.consultarTodos());
	}

}
