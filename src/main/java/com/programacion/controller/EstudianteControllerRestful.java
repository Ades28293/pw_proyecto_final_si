package com.programacion.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.service.IEstudianteService;
import com.programacion.service.IForoService;
import com.programacion.service.INoticiaService;
import com.programacion.service.to.EstudianteTO;
import com.programacion.service.to.ForoTO;
import com.programacion.service.to.NoticiaTO;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestful {
	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private INoticiaService noticiaService;

	@Autowired
	private IForoService foroService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteTO> consultarPorCedula(@PathVariable String cedula) {
		return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.consultarPorCedula(cedula));
	}

	@GetMapping(path = "/{cedula}/foros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ForoTO>> consultarForos(@PathVariable String cedula) {
		List<ForoTO> lista = this.foroService.buscarPorCedula(cedula);
		for (ForoTO n : lista) {
			Link myLink = linkTo(
					methodOn(EstudianteControllerRestful.class).consultarPorCedula(n.getCedulaEstudiante()))
					.withRel("autor");

			n.add(myLink);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{cedula}/noticias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NoticiaTO>> consultarNoticias(@PathVariable String cedula) {
		List<NoticiaTO> lista = this.noticiaService.consultaPorCedulaEst(cedula);
		for (NoticiaTO n : lista) {
			Link myLink = linkTo(
					methodOn(EstudianteControllerRestful.class).consultarPorCedula(n.getCedulaEstudiante()))
					.withRel("autor");

			n.add(myLink);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
}
