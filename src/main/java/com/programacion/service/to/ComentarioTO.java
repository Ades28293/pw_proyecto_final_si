package com.programacion.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.programacion.repository.modelo.Comentario;

public class ComentarioTO extends RepresentationModel<ComentarioTO> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String descripcion;
	private String asuntoForo;
	private LocalDateTime fecha;
	private String cedulaEstudiante;

	public Comentario convertir() {
		Comentario c = new Comentario();
		c.setId(this.id);
		c.setDescripcion(this.descripcion);
		c.setFecha(this.fecha);
		return c;
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAsuntoForo() {
		return asuntoForo;
	}

	public void setAsuntoForo(String asuntoForo) {
		this.asuntoForo = asuntoForo;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

}
