package com.programacion.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.programacion.repository.modelo.Foro;

public class ForoTO extends RepresentationModel<ForoTO> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String asunto;
	private String descripcion;
	private LocalDateTime fecha;
	private String cedulaEstudiante;

	public Foro convertir() {
		Foro f = new Foro();
		f.setId(this.id);
		f.setAsunto(this.asunto);
		f.setDescripcion(this.descripcion);
		f.setFecha(this.fecha);
		return f;
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}
	
	
	
	
}
