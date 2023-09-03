package com.programacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IEstudianteRepository;
import com.programacion.repository.IForoRepository;
import com.programacion.repository.modelo.Foro;
import com.programacion.service.to.ForoTO;

@Service
public class ForoServiceImpl implements IForoService {

	@Autowired
	private IForoRepository foroRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void nuevoForo(ForoTO foro) {
		Foro f = foro.convertir();
		f.setEstudiante(this.estudianteRepository.buscarPorCedula(foro.getCedulaEstudiante()));

		this.foroRepository.crearForo(f);
	}

	@Override
	public ForoTO buscarPorAsunto(String asunto) {
		return this.foroRepository.buscarForo(asunto).convertir();
	}

	@Override
	public void actualizarForo(ForoTO foro) {
		Foro f = foro.convertir();
		f.setEstudiante(this.estudianteRepository.buscarPorCedula(foro.getCedulaEstudiante()));

		// forma de setear los comentarios

		this.foroRepository.actualizarForo(f);
	}

	@Override
	public void eliminarForo(Integer id) {
		this.foroRepository.eliminarForo(id);
	}

	@Override
	public ForoTO buscarPorId(Integer id) {
		return this.foroRepository.buscarPorId(id).convertir();
	}

	@Override
	public List<ForoTO> buscarForos() {
		// TODO Auto-generated method stub
		List<Foro>listaForo= this.foroRepository.buscarTodos();
		List<ForoTO>listaFoTO=listaForo.stream().map(foro->foro.convertir()).collect(Collectors.toList());
		return listaFoTO;
	}

}
