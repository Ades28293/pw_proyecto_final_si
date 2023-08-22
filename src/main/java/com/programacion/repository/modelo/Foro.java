package com.programacion.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.programacion.service.to.ForoTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "foro")
public class Foro {

	@Id
	@Column(name = "foro_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foro_id_seq")
	@SequenceGenerator(name = "foro_id_seq", sequenceName = "foro_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "foro_asunto")
	private String asunto;

	@Column(name = "foro_descripcion")
	private String descripcion;

	@Column(name = "foro_fecha")
	private LocalDateTime fecha;

	@OneToMany(mappedBy = "foro")
	private List<Comentario> comentarios;

	@ManyToOne
	@JoinColumn(name = "foro_id_estu")
	private Estudiante estudiante;

	public ForoTO convertir() {
		ForoTO f = new ForoTO();
		f.setId(this.id);
		f.setAsunto(this.asunto);
		f.setDescripcion(this.descripcion);
		f.setCedulaEstudiante(this.estudiante.getCedula());
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}
