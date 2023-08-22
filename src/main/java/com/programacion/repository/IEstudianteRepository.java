package com.programacion.repository;

import com.programacion.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertar(Estudiante estudiante);

	public Estudiante buscarPorId(Integer id);

	public Estudiante buscarPorCedula(String cedula);

}
