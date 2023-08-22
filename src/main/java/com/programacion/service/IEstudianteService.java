package com.programacion.service;

import com.programacion.service.to.EstudianteTO;

public interface IEstudianteService {

	public void guardar(EstudianteTO estudiante);

	public EstudianteTO consultarPorId(Integer id);

	public EstudianteTO consultarPorCedula(String cedula);

}
