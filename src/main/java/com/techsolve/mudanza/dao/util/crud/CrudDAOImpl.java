package com.techsolve.mudanza.dao.util.crud;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

import com.techsolve.mudanza.dao.exception.DaoException;

public class CrudDAOImpl<T, ID> implements CrudDAO<T, ID> {

	private EntityManager entityManager;
	private Class<T> entityClass;

	public CrudDAOImpl(EntityManager entityManager, Class<T> entityClass) {
		this.entityManager = entityManager;
		this.entityClass = entityClass;
	}

	@Override
	public T create(T t) throws DaoException {
		try {
			entityManager.persist(t);
			commit();
			return t;
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public T update(T t) throws DaoException {
		try {
			entityManager.merge(t);
			commit();
			return t;
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public T find(ID id) throws DaoException {
		try {
			return entityManager.find(entityClass, id);
		} catch (IllegalArgumentException e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void delete(T t) throws DaoException {
		try {
			entityManager.remove(t);
			commit();
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	private void commit() {
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		entityManager.getTransaction().commit();
	}

}
