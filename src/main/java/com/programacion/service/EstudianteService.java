package com.programacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IEstudianteRepository;
import com.programacion.repository.modelo.Estudiante;
@Service
public class EstudianteService implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	
	@Override
	public Estudiante consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

}
