package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.Comentario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ComentarioRepositoryImpl implements IComentarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarComentario(Comentario comentario) {
		this.entityManager.persist(comentario);
	}

	@Override
	public Comentario consultarPorId(Integer id) {
		return this.entityManager.find(Comentario.class, id);
	}

	@Override
	public List<Comentario> consultarPorForo(String asunto) {
		TypedQuery<Comentario> query = this.entityManager
				.createQuery("SELECT c FROM Comentario c WHERE c.foro.asunto =: asuntoForo", Comentario.class);
		query.setParameter("asuntoForo", asunto);
		return query.getResultList();
	}

	@Override
	public List<Comentario> consultarPorEstudiante(String cedula) {
		TypedQuery<Comentario> query = this.entityManager.createQuery(
				"SELECT c FROM Comentario c WHERE c.estudiante.cedula =: cedulaEstudiante", Comentario.class);
		query.setParameter("cedulaEstudiante", cedula);
		return query.getResultList();
	}

	@Override
	public void actualizar(Comentario comentario) {
		this.entityManager.merge(comentario);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.consultarPorId(id));
	}

}
