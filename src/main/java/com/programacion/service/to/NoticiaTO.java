package com.programacion.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.programacion.repository.modelo.Noticia;

public class NoticiaTO extends RepresentationModel<NoticiaTO> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tituloCorto;
	private String tituloLargo;
	private String descripcion;
	private LocalDateTime fecha;
	private String cedulaEstudiante;
	private String urlImagen;
	private String urlVideo;

	public Noticia convertir() {
		Noticia n = new Noticia();
		n.setId(this.id);
		n.setTituloCorto(this.tituloCorto);
		n.setTituloLargo(this.tituloLargo);
		n.setDescripcion(this.descripcion);
		n.setFecha(this.fecha);
		n.setUrlImagen(this.urlImagen);
		n.setUrlVideo(this.urlVideo);
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

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	
}
