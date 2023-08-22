package com.programacion.repository;

import com.programacion.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante seleccionarPorCedula(String cedula);

	public void insertar(Estudiante estudiante);
}
