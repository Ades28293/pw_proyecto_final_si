package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.Foro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ForoRepositoryImpl implements IForoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crearForo(Foro foro) {
		this.entityManager.persist(foro);
	}

	@Override
	public Foro buscarForo(String asunto) {
		TypedQuery<Foro> myQuery = this.entityManager.createQuery("SELECT f FROM Foro f WHERE f.asunto=:datoAsunto",
				Foro.class);
		myQuery.setParameter("datoAsunto", asunto);
		return myQuery.getSingleResult();
	}

	@Override
	public Foro buscarPorId(Integer id) {
		return this.entityManager.find(Foro.class, id);
	}

	@Override
	public void actualizarForo(Foro foro) {
		this.entityManager.merge(foro);
	}

	@Override
	public void eliminarForo(Integer id) {
		Foro foro = this.buscarPorId(id);
		this.entityManager.remove(foro);
	}

	@Override
	public List<Foro> buscarPorCedula(String cedula) {
		TypedQuery<Foro> query = this.entityManager
				.createQuery("SELECT f FROM Foro f WHERE f.estudiante.cedula = :datoCedula", Foro.class);
		query.setParameter("datoCedula", cedula);
		return query.getResultList();
	}

}
