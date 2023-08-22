package com.programacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.repository.modelo.Materia;
import com.programacion.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestful {

	@Autowired
	private IMateriaService iMateriaService;

	@GetMapping(path = "/buscar/{asignatura}")
	public Materia consultarNombreMateria(@PathVariable String asignatura) {
		return this.iMateriaService.seleccionarPorMateria(asignatura);
	}

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.iMateriaService.registrar(materia);
	}

	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
		materia.setId(identificador);
		this.iMateriaService.actualizar(materia);
	}

	@PatchMapping(path = "/actualizarParcial/{identificador}")
	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer identificador) {
		Materia mat1 = this.iMateriaService.buscarPorId(identificador);
		mat1.setNombre(materia.getNombre());
		this.iMateriaService.actualizar(mat1);
	}

	@DeleteMapping(path = "/eliminar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iMateriaService.borrar(id);
	}

}
