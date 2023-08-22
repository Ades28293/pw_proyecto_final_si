package com.programacion.repository.modelo;

import java.time.LocalDateTime;

import com.programacion.service.to.NoticiaTO;

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
@Table(name = "noticia")
public class Noticia {

	@Id
	@Column(name = "noti_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noti_id_seq")
	@SequenceGenerator(name = "noti_id_seq", sequenceName = "noti_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "noti_titulo_corto")
	private String tituloCorto;

	@Column(name = "noti_titulo_largo")
	private String tituloLargo;

	@Column(name = "noti_descripcion")
	private String descripcion;

	@Column(name = "noti_fecha")
	private LocalDateTime fecha;

	@ManyToOne
	@JoinColumn(name = "noti_id_estu")
	private Estudiante estudiante;

	public NoticiaTO convertir() {
		NoticiaTO n = new NoticiaTO();
		n.setId(this.id);
		n.setTituloCorto(this.tituloCorto);
		n.setTituloLargo(this.tituloLargo);
		n.setDescripcion(this.descripcion);
		n.setCedulaEstudiante(this.estudiante.getCedula());
		return n;
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTituloCorto() {
		return tituloCorto;
	}

	public void setTituloCorto(String tituloCorto) {
		this.tituloCorto = tituloCorto;
	}

	public String getTituloLargo() {
		return tituloLargo;
	}

	public void setTituloLargo(String tituloLargo) {
		this.tituloLargo = tituloLargo;
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
