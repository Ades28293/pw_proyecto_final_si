package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Aula;

public interface IAulaRepository {
	
	public void guardar(Aula aula);
	
	public void actualizar(Aula aula);
	
	public void actualizarParcial(String paraleloOld, String paraleloNew);
	
	public Aula buscar(String paralelo);
	
	public List<Aula> buscarTodos(String tipo);

	public Aula buscarId(Integer id);
	
	public void eliminar(Integer id);
		
}
