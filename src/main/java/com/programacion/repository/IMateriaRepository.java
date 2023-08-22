package com.programacion.repository;

import com.programacion.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public Materia seleccionarPorNombre(String nombre);
	
	public void insertar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public Materia buscarPorId(Integer id);
	
	public void eliminar(Integer id);
	
}
