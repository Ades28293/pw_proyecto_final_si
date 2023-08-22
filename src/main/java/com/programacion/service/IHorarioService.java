package com.programacion.service;

import java.util.List;

import com.programacion.repository.modelo.Horario;

public interface IHorarioService {
	
	public Horario buscarPorCodigo(String codigo);

	public void ingresar(Horario horario);

	public void actualizar(Horario horario);

	public Horario buscar(Integer id);

	public void borrar(Integer id);
	
	public List<Horario> filtro(String modalidad);
}
