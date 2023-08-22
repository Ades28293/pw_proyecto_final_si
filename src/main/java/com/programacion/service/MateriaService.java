package com.programacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IMateriaRepository;
import com.programacion.repository.modelo.Materia;
@Service
public class MateriaService implements IMateriaService {
	
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	
	@Override
	public Materia seleccionarPorMateria(String asignatura) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionarPorNombre(asignatura);
	}

	@Override
	public void registrar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizar(materia);
	}

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarPorId(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.eliminar(id);
	}

}
