package com.techsolve.mudanza.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Utility Class to manage the entity manager
 * 
 * @author David Martinez
 *
 */
public final class EntityManagerUtil {

	private static final String MUDANZA_DB = "mudanzaDB";
	private static EntityManager em;

	public static EntityManager getEntityManager() {
		return em == null ? Persistence.createEntityManagerFactory(MUDANZA_DB).createEntityManager() : em;
	}

}
