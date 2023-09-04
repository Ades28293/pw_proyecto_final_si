package com.programacion.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IComentarioRepository;
import com.programacion.repository.IEstudianteRepository;
import com.programacion.repository.IForoRepository;
import com.programacion.repository.modelo.Comentario;
import com.programacion.repository.modelo.Noticia;
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
	public ComentarioTO buscarPorId(Integer id) {
		return this.comentarioRepository.consultarPorId(id).convertir();
	}

	@Override
	public List<ComentarioTO> buscarPorForo(String asunto) {
		return this.comentarioRepository.consultarPorForo(asunto).stream().map(c -> c.convertir())
				.collect(Collectors.toList());
	}

	@Override
	public List<ComentarioTO> buscarPorEstudiante(String cedula) {
		return this.comentarioRepository.consultarPorEstudiante(cedula).stream().map(c -> c.convertir())
				.collect(Collectors.toList());
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

	@Override
	public List<ComentarioTO> buscarTodos() {

		List<Comentario> lista = this.comentarioRepository.buscarTodos();
		return lista.stream().map(c -> c.convertir()).collect(Collectors.toList());
	}

}
