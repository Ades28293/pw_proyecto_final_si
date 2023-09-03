package com.programacion.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.programacion.service.IForoService;
import com.programacion.service.to.ForoTO;

@RestController
@CrossOrigin
@RequestMapping("/foros")
public class ForoControllerRestFul {

	@Autowired
	private IForoService foroService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void nuevoForo(@RequestBody ForoTO foro) {
		foro.setFecha(LocalDateTime.now());
		this.foroService.nuevoForo(foro);
	}

	@GetMapping(path = "/{asunto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ForoTO> consultarPorAsunto(@PathVariable String asunto) {
		ForoTO foro = this.foroService.buscarPorAsunto(asunto);
		return new ResponseEntity<>(foro, null, HttpStatus.OK);
	}

	@PutMapping(path = "/{identificador}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizarForo(@RequestBody ForoTO foro, @PathVariable Integer identificador) {
		foro.setId(identificador);
		this.foroService.actualizarForo(foro);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminarForo(@PathVariable Integer id) {
		this.foroService.eliminarForo(id);
	}

}
