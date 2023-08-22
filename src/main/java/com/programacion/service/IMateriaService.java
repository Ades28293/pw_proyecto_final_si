package com.programacion.service;

import com.programacion.repository.modelo.Materia;

public interface IMateriaService {

	public Materia seleccionarPorMateria(String asignatura);

	public void registrar(Materia materia);

	public void actualizar(Materia materia);

	public Materia buscarPorId(Integer id);

	public void borrar(Integer id);

}
