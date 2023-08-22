package com.programacion.service;

import java.util.List;

import com.programacion.repository.modelo.Comentario;
import com.programacion.service.to.ComentarioTO;

public interface IComentarioService {

	public void agregarComentario(ComentarioTO comentario);

	public Comentario buscarPorId(Integer id);

	public List<Comentario> buscarPorForo(String asunto);

	public List<Comentario> buscarPorEstudiante(String cedula);

	public void editar(ComentarioTO comentario);

	public void eliminar(Integer id);

}
