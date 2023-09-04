package com.programacion.service;

import java.util.List;

import com.programacion.service.to.ComentarioTO;

public interface IComentarioService {

	public void agregarComentario(ComentarioTO comentario);

	public ComentarioTO buscarPorId(Integer id);

	public List<ComentarioTO> buscarPorForo(String asunto);

	public List<ComentarioTO> buscarPorEstudiante(String cedula);

	public void editar(ComentarioTO comentario);

	public void eliminar(Integer id);
	
	public List<ComentarioTO> buscarTodos();


}
