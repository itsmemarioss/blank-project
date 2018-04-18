package br.com.cactus.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class GenericDAO<E,I> implements Serializable {
	
	@PersistenceContext
	EntityManager entityManager;
	private final Class<E> entityClass;
	
	public GenericDAO(Class clazz){
		entityClass = clazz;
	}
	
	@Transactional
	public void salvar(E entity){
		entityManager.persist(entity);
	}
	
	@Transactional
	public E atualizar(E entity){
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Optional<E> buscar(I id){
		return Optional.ofNullable(entityManager.find(entityClass, id));
	}
	
	@Transactional
	public List<E> listar(String query){
		return entityManager.createQuery(query,entityClass).getResultList();
	}
	
	@Transactional
	public void remover(I id){	
		entityManager.remove(entityManager.find(entityClass, id));
	}
	
}
