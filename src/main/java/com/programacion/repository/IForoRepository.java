package com.programacion.repository;

import com.programacion.repository.modelo.Foro;

public interface IForoRepository {

	public void crearForo(Foro foro);

	public Foro buscarForo(String asunto);

	public void actualizarForo(Foro foro);

	public void eliminarForo(Integer id);

	public Foro buscarPorId(Integer id);
	
}
