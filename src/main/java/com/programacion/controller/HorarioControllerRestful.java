package com.programacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.repository.modelo.Horario;
import com.programacion.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestful {
	@Autowired
	private IHorarioService horarioService;

	@GetMapping(path = "/{codigo}")
	public Horario buscarPorCodigo(@PathVariable String codigo) {

		return this.horarioService.buscarPorCodigo(codigo);
	}

	@PostMapping
	public void ingresar(@RequestBody Horario horario) {
		this.horarioService.ingresar(horario);
	}

	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador);
		this.horarioService.actualizar(horario);
	}
	
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador) {
		Horario h1=this.horarioService.buscar(identificador);
		h1.setSemestre(horario.getSemestre());
		this.horarioService.actualizar(h1);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.horarioService.borrar(id);
	}

	@GetMapping
	public List<Horario> filtro(@RequestParam String modalidad) {
		return this.horarioService.filtro(modalidad);

	}
}
