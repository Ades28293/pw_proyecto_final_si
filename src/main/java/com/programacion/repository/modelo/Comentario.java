package com.programacion.repository.modelo;

import java.time.LocalDateTime;

import com.programacion.service.to.ComentarioTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@Column(name = "come_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "come_id_seq")
	@SequenceGenerator(name = "come_id_seq", sequenceName = "come_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "come_descripcion")
	private String descripcion;

	@Column(name = "come_fecha")
	private LocalDateTime fecha;

	@ManyToOne
	@JoinColumn(name = "come_id_estu")
	private Estudiante estudiante;

	@ManyToOne
	@JoinColumn(name = "come_id_foro")
	private Foro foro;

	public ComentarioTO convertir() {
		ComentarioTO c = new ComentarioTO();
		c.setId(this.id);
		c.setDescripcion(this.descripcion);
		c.setAsuntoForo(this.foro.getAsunto());
		c.setCedulaEstudiante(this.estudiante.getCedula());
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Foro getForo() {
		return foro;
	}

	public void setForo(Foro foro) {
		this.foro = foro;
	}

}
