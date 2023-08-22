package com.programacion.service;

import java.util.List;

import com.programacion.service.to.NoticiaTO;

public interface INoticiaService {

	public void guardar(NoticiaTO noticia);

	public NoticiaTO buscarID(Integer id);

	public NoticiaTO buscar(String tituloCorto);

	public List<NoticiaTO> consultaPorCedulaEst(String cedula);

	public List<NoticiaTO> consultarTodos();

	public void actualizar(NoticiaTO noticia);

	public void borrar(String tituloCorto);

}
