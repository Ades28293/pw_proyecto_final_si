package com.programacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.service.IEstudianteService;
import com.programacion.service.to.EstudianteTO;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {
	@Autowired
	private IEstudianteService estudianteService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public EstudianteTO consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.consultarPorCedula(cedula);
	}

	// @GetMapping(path ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
	// @ResponseStatus(HttpStatus.OK)
	// public Estudiante consultarPorId(@PathVariable Integer id) {
	// return this.estudianteService.consultarPorId(id);
	// }
}
