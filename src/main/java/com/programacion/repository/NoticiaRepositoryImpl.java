package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class NoticiaRepositoryImpl implements INoticiaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Noticia noticia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(noticia);
	}

	@Override
	public Noticia buscarID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Noticia.class, id);
	}

	@Override
	public Noticia buscarTituloCorto(String tituloCorto) {
		// TODO Auto-generated method stub
		TypedQuery<Noticia> myQ = this.entityManager
				.createQuery("SELECT n FROM Noticia n WHERE n.tituloCorto=: datoTitulo ", Noticia.class);
		myQ.setParameter("datoTitulo", tituloCorto);
		return myQ.getSingleResult();
	}

	@Override
	public List<Noticia> consultaPorEstudiante(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Noticia> myQ = this.entityManager
				.createQuery("SELECT n FROM Noticia n WHERE n.estudiante.cedula=: datoEstudiante ", Noticia.class);
		myQ.setParameter("datoEstudiante", cedula);
		return myQ.getResultList();
	}

	@Override
	public void actualizar(Noticia noticia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(noticia);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarID(id));
	}

	@Override
	public List<Noticia> consultarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Noticia> myQ = this.entityManager.createQuery("SELECT n FROM Noticia n", Noticia.class);
		return myQ.getResultList();
	}

}
