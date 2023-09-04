package com.programacion.service;

import java.util.List;

import com.programacion.service.to.ForoTO;

public interface IForoService {

	public void nuevoForo(ForoTO foro);

	public ForoTO buscarPorAsunto(String asunto);

	public ForoTO buscarPorId(Integer id);

	public void actualizarForo(ForoTO foro);

	public void eliminarForo(Integer id);
	
	public List<ForoTO> buscarForos();

	public List<ForoTO> buscarPorCedula(String cedula);

}
