package com.programacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IEstudianteRepository;
import com.programacion.repository.INoticiaRepository;
import com.programacion.repository.modelo.Noticia;
import com.programacion.service.to.NoticiaTO;

@Service
public class NoticiaServiceImpl implements INoticiaService {

	@Autowired
	private INoticiaRepository noticiaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(NoticiaTO noticia) {
		// TODO Auto-generated method stub
		Noticia n = noticia.convertir();
		n.setEstudiante(this.estudianteRepository.buscarPorCedula(noticia.getCedulaEstudiante()));

		this.noticiaRepository.insertar(n);
	}

	@Override
	public NoticiaTO buscarID(Integer id) {
		// TODO Auto-generated method stub
		return this.noticiaRepository.buscarID(id).convertir();
	}

	@Override
	public NoticiaTO buscar(String tituloCorto) {
		// TODO Auto-generated method stub
		return this.noticiaRepository.buscarTituloCorto(tituloCorto).convertir();
	}

	@Override
	public List<NoticiaTO> consultaPorCedulaEst(String cedula) {
		// TODO Auto-generated method stub
		List<Noticia> lista = this.noticiaRepository.consultaPorEstudiante(cedula);
		return lista.stream().map(n -> n.convertir()).collect(Collectors.toList());
	}

	@Override
	public void actualizar(NoticiaTO noticia) {
		// TODO Auto-generated method stub
		Noticia n = noticia.convertir();
		n.setEstudiante(this.estudianteRepository.buscarPorCedula(noticia.getCedulaEstudiante()));

		this.noticiaRepository.actualizar(n);
	}

	@Override
	public void borrar(String tituloCorto) {
		// TODO Auto-generated method stub
		Noticia noti = this.noticiaRepository.buscarTituloCorto(tituloCorto);
		this.noticiaRepository.eliminar(noti.getId());
	}

	@Override
	public List<NoticiaTO> consultarTodos() {
		// TODO Auto-generated method stub
		List<Noticia> lista = this.noticiaRepository.consultarTodos();
		return lista.stream().map(n -> n.convertir()).collect(Collectors.toList());
	}

}
