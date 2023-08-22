package com.programacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.repository.modelo.Aula;
import com.programacion.service.IAulaService;

@RestController
@RequestMapping("/aulas")
public class AulaControllerRestful {

	@Autowired
	private IAulaService aulaService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void registrar(@RequestBody Aula aula) {
		this.aulaService.registrar(aula);
	}

	@PutMapping(path = "/{identificador}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody Aula aula, @PathVariable Integer identificador) {
		aula.setId(identificador);
		this.aulaService.actualizar(aula);
	}

	@PatchMapping(path = "/{paralelo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizarParalelo(@RequestBody Aula aula, @PathVariable String paralelo) {
		Aula aula1 = this.aulaService.buscar(paralelo);
		this.aulaService.actualizarParalelo(aula1.getParalelo(), aula.getParalelo());
	}

	@GetMapping(path = "/{paralelo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aula> buscar(@PathVariable String paralelo) {
		return ResponseEntity.status(HttpStatus.OK).body(this.aulaService.buscar(paralelo));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Aula>> filtrar(@RequestParam String tipo) {
		return ResponseEntity.status(HttpStatus.OK).body(this.aulaService.filtrar(tipo));
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void borrar(@PathVariable Integer id) {
		this.aulaService.borrar(id);
	}

}
