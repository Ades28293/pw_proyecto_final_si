package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Noticia;

public interface INoticiaRepository {

	public void insertar(Noticia noticia);

	public Noticia buscarID(Integer id);

	public Noticia buscarTituloCorto(String tituloCorto);

	public List<Noticia> consultaPorEstudiante(String cedula);

	public void actualizar(Noticia noticia);

	public void eliminar(Integer id);

	public List<Noticia> consultarTodos();

}
