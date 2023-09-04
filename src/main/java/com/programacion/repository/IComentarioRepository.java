package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Comentario;

public interface IComentarioRepository {

	public void insertarComentario(Comentario comentario);

	public Comentario consultarPorId(Integer id);

	public List<Comentario> consultarPorForo(String asunto);

	public List<Comentario> consultarPorEstudiante(String cedula);

	public void actualizar(Comentario comentario);

	public void eliminar(Integer id);
	
	public List<Comentario> buscarTodos();

}
