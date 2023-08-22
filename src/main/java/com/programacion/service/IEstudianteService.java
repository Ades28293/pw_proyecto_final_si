package com.programacion.service;

import com.programacion.repository.modelo.Estudiante;

public interface IEstudianteService {
	public Estudiante consultarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);
}
