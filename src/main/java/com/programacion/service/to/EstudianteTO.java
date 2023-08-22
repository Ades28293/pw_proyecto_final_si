package com.programacion.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.programacion.repository.modelo.Estudiante;

public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cedula;
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;

	public Estudiante convertir() {
		Estudiante e = new Estudiante();
		e.setId(this.id);
		e.setCedula(this.cedula);
		e.setNombre(this.nombre);
		e.setApellido(this.apellido);
		e.setFechaNacimiento(this.fechaNacimiento);
		return e;
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
