package com.programacion.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {
	
	@Id
	@Column(name="hor_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hor_id_seq")
	@SequenceGenerator(name="hor_id_seq", sequenceName = "hor_id_seq" , allocationSize = 1)
	private Integer id;
	
	@Column(name="hor_codigo")
	private String codigo;
	
	@Column(name="hor_semestre")
	private String semestre;
	
	@Column(name="hor_modalidad")
	private String modalidad;
	
	
	//GET y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	
	
	
}
