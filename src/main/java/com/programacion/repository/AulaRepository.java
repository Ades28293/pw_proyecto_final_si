package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.Aula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class AulaRepository implements IAulaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void guardar(Aula aula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(aula);
	}

	@Override
	public void actualizar(Aula aula) {
		// TODO Auto-generated method stub
		this.entityManager.merge(aula);
	}

	@Override
	public Aula buscar(String paralelo) {
		// TODO Auto-generated method stub
		TypedQuery<Aula>myQuery=this.entityManager.createQuery("SELECT a FROM Aula a WHERE a.paralelo=:datoParalelo", Aula.class);
		myQuery.setParameter("datoParalelo", paralelo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Aula> buscarTodos(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Aula>myQuery=this.entityManager.createQuery("SELECT a FROM Aula a WHERE a.tipo=:datoTipo", Aula.class);
		myQuery.setParameter("datoTipo", tipo);
		return myQuery.getResultList();
		
	}

	@Override
	public Aula buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Aula.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarId(id));
	}

	@Override
	public void actualizarParcial(String paraleloOld, String paraleloNew) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("UPDATE Aula a SET a.paralelo=:datoParaleloNew WHERE a.paralelo=:datoParaleloOld");
		myQuery.setParameter("datoParaleloNew", paraleloNew);
		myQuery.setParameter("datoParaleloOld", paraleloOld);
		myQuery.executeUpdate();
	}

}
