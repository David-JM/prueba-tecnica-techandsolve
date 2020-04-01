package com.techsolve.mudanza.dao.util.crud;

import com.techsolve.mudanza.dao.exception.DaoException;

/**
 * Generic DAO that define CRUD basic operations
 * 
 * @author David Martinez
 *
 * @param <T>
 * @param <ID>
 */
public interface CrudDAO<T, ID> {

	/**
	 * Method that persists an object
	 * 
	 * @param t
	 * @return
	 * @throws DaoException
	 */
	public T create(T t) throws DaoException;

	/**
	 * Method that updates an object
	 * 
	 * @param t
	 * @return
	 * @throws DaoExceptio
	 */
	public T update(T t) throws DaoException;

	/**
	 * Method that finds an object by id
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public T find(ID id) throws DaoException;

	/**
	 * Method that deletes an object
	 * 
	 * @param t
	 * @throws DaoExceptio
	 */
	public void delete(T t) throws DaoException;
}
