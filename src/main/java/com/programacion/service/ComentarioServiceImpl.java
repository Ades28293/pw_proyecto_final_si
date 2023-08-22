package com.programacion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IComentarioRepository;
import com.programacion.repository.IEstudianteRepository;
import com.programacion.repository.IForoRepository;
import com.programacion.repository.modelo.Comentario;
import com.programacion.service.to.ComentarioTO;

@Service
public class ComentarioServiceImpl implements IComentarioService {

	@Autowired
	private IComentarioRepository comentarioRepository;

	@Autowired
	private IForoRepository foroRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void agregarComentario(ComentarioTO comentario) {
		Comentario c = comentario.convertir();
		c.setFecha(LocalDateTime.now());
		c.setForo(this.foroRepository.buscarForo(comentario.getAsuntoForo()));
		c.setEstudiante(this.estudianteRepository.buscarPorCedula(comentario.getCedulaEstudiante()));

		this.comentarioRepository.insertarComentario(c);
	}

	@Override
	public Comentario buscarPorId(Integer id) {
		return this.comentarioRepository.consultarPorId(id);
	}

	@Override
	public List<Comentario> buscarPorForo(String asunto) {
		return this.comentarioRepository.consultarPorForo(asunto);
	}

	@Override
	public List<Comentario> buscarPorEstudiante(String cedula) {
		return this.comentarioRepository.consultarPorEstudiante(cedula);
	}

	@Override
	public void editar(ComentarioTO comentario) {
		Comentario c = comentario.convertir();
		c.setFecha(LocalDateTime.now());
		c.setForo(this.foroRepository.buscarForo(comentario.getAsuntoForo()));
		c.setEstudiante(this.estudianteRepository.buscarPorCedula(comentario.getCedulaEstudiante()));

		this.comentarioRepository.actualizar(c);
	}

	@Override
	public void eliminar(Integer id) {
		this.comentarioRepository.eliminar(id);
	}

}
