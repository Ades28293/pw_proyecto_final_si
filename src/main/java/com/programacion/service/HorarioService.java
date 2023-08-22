package com.programacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IHorarioRepository;
import com.programacion.repository.modelo.Horario;
@Service
public class HorarioService implements IHorarioService{
	
	@Autowired
	private IHorarioRepository horarioRepository;
	
	@Override
	public Horario buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.horarioRepository.seleccionarCodigo(codigo);
	}

	@Override
	public void ingresar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.insertar(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizar(horario);
	}

	@Override
	public Horario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepository.buscarPorId(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.horarioRepository.eliminar(id);
	}

	@Override
	public List<Horario> filtro(String modalidad) {
		// TODO Auto-generated method stub
		return this.horarioRepository.buscarTipos(modalidad);
	}

}
