package com.programacion.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.repository.modelo.Comentario;
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
		this.comentarioService.agregarComentario(comentario);
	}

	// GET
	@GetMapping(path = "/{asunto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ComentarioTO>> buscarPorForo(@PathVariable String asunto) {
		List<Comentario> comentarios = this.comentarioService.buscarPorForo(asunto);
		List<ComentarioTO> comentariosTO = comentarios.stream().map(c -> c.convertir()).collect(Collectors.toList());

		return new ResponseEntity<>(comentariosTO, new HttpHeaders(), HttpStatus.OK);
	}

//	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<ComentarioTO>> buscarPorEstudiante(@PathVariable String cedula) {
//		
//	}

	// PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void editar(@PathVariable Integer id, @RequestBody ComentarioTO comentario) {
		comentario.setId(id);
		this.comentarioService.editar(comentario);
	}

}
