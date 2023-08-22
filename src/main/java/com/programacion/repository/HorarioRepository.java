package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepository implements IHorarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Horario seleccionarCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager
				.createQuery("SELECT h FROM Horario h WHERE h.codigo =:datoCodigo ", Horario.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public Horario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class,id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public List<Horario> buscarTipos(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery= this.entityManager.createQuery("SELECT h FROM Horario h WHERE h.modalidad =:datoTipo", Horario.class );
		myQuery.setParameter("datoTipo", tipo);
		return myQuery.getResultList();
	}
	
	

}
