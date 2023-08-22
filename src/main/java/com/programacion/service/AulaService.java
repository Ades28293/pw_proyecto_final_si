package com.programacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IAulaRepository;
import com.programacion.repository.modelo.Aula;
@Service
public class AulaService implements IAulaService {
	
	@Autowired
	private IAulaRepository aulaRepository;
	
	
	@Override
	public void registrar(Aula aula) {
		// TODO Auto-generated method stub
		this.aulaRepository.guardar(aula);
	}

	@Override
	public void actualizar(Aula aula) {
		// TODO Auto-generated method stub
		this.aulaRepository.actualizar(aula);
	}

	@Override
	public Aula buscar(String paralelo) {
		// TODO Auto-generated method stub
		return this.aulaRepository.buscar(paralelo);
	}

	@Override
	public List<Aula> filtrar(String tipo) {
		// TODO Auto-generated method stub
		return this.aulaRepository.buscarTodos(tipo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.aulaRepository.eliminar(id);
	}

	@Override
	public void actualizarParalelo(String paraleloOld, String paraleloNew) {
		// TODO Auto-generated method stub
		this.aulaRepository.actualizarParcial(paraleloOld, paraleloNew);
	}
	
	
}
