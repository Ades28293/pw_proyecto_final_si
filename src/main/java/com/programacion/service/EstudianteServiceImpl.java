package com.programacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IEstudianteRepository;
import com.programacion.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante.convertir());
	}

	@Override
	public EstudianteTO consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarPorId(id).convertir();
	}

	@Override
	public EstudianteTO consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarPorCedula(cedula).convertir();
	}

}
