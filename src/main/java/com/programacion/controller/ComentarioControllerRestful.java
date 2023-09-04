package com.programacion.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.service.IComentarioService;
import com.programacion.service.to.ComentarioTO;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin
public class ComentarioControllerRestful {

	@Autowired
	private IComentarioService comentarioService;

	// POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void registrarComentario(@RequestBody ComentarioTO comentario) {
		comentario.setFecha(LocalDateTime.now());
		this.comentarioService.agregarComentario(comentario);
	}

	// GET
	@GetMapping(path = "/{asunto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ComentarioTO>> buscarPorForo(@PathVariable String asunto) {
		List<ComentarioTO> comentarios = this.comentarioService.buscarPorForo(asunto);

		return new ResponseEntity<>(comentarios, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ComentarioTO>> consultarTodos() {
		List<ComentarioTO> lista = this.comentarioService.buscarTodos();
		for (ComentarioTO c : lista) {
			Link myLink = linkTo(methodOn(ComentarioControllerRestful.class).buscarPorId(c.getId())).withSelfRel();
			c.add(myLink);
		}

		return new ResponseEntity<>(lista, null, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComentarioTO> buscarPorId(@PathVariable Integer id) {
		ComentarioTO comentario = this.comentarioService.buscarPorId(id);

		return new ResponseEntity<>(comentario, null, HttpStatus.OK);
	}

	// PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void editar(@PathVariable Integer id, @RequestBody ComentarioTO comentario) {
		comentario.setId(id);
		this.comentarioService.editar(comentario);
	}

	// DELETE
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable Integer id) {
		this.comentarioService.eliminar(id);
	}

}
