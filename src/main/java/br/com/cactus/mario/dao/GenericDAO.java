package br.com.cactus.mario.dao;

import br.com.cactus.mario.transaction.Transacional;
import java.util.Optional;
import javax.inject.Inject;

import javax.persistence.EntityManager;

public abstract class GenericDAO<E, K> {

    @Inject
    EntityManager entityManager;
    private final Class<E> entityClass;

    public GenericDAO(Class clazz) {
        entityClass = clazz;
    }

    @Transacional
    public void salvar(E entity) {
        entityManager.persist(entity);
    }

    @Transacional
    public E atualizar(E entity) {
        return entityManager.merge(entity);
    }

    @Transacional
    public Optional<E> buscar(K id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }
    
}
