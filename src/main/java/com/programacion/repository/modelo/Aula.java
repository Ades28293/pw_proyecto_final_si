package com.programacion.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="aula")
public class Aula {
	@Id
	@Column(name="aul_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "aul_id_seq")
	@SequenceGenerator(name = "aul_id_seq", sequenceName = "aul_id_seq", allocationSize =1 )
	private Integer id;
	@Column(name="aul_paralelo")
	private String paralelo;
	@Column(name="aul_facultad")
	private String facultad;
	@Column(name="aul_tipo")
	private String tipo;
	
	

	//GET y SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParalelo() {
		return paralelo;
	}
	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
