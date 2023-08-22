package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Horario;

public interface IHorarioRepository {

	public Horario seleccionarCodigo(String codigo);

	public void insertar(Horario horario);

	public void actualizar(Horario horario);

	public Horario buscarPorId(Integer id);

	public void eliminar(Integer id);
	
	public List<Horario> buscarTipos(String modalidad);

}
