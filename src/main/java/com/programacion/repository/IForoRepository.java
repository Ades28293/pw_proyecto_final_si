package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Foro;

public interface IForoRepository {

	public void crearForo(Foro foro);

	public Foro buscarForo(String asunto);

	public void actualizarForo(Foro foro);

	public void eliminarForo(Integer id);

	public Foro buscarPorId(Integer id);
	
	public List<Foro> buscarTodos();
	
}
