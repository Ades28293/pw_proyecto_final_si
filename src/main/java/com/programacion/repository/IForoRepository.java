package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Foro;

public interface IForoRepository {

	public void crearForo(Foro foro);

	public Foro buscarForo(String asunto);

	public Foro buscarPorId(Integer id);

	public void actualizarForo(Foro foro);

	public void eliminarForo(Integer id);

	public List<Foro> buscarPorCedula(String cedula);

	public List<Foro> buscarTodos();

}
