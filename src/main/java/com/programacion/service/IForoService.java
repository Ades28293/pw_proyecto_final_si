package com.programacion.service;

import com.programacion.service.to.ForoTO;

public interface IForoService {

	public void nuevoForo(ForoTO foro);

	public ForoTO buscarPorAsunto(String asunto);

	public ForoTO buscarPorId(Integer id);

	public void actualizarForo(ForoTO foro);

	public void eliminarForo(Integer id);

}
