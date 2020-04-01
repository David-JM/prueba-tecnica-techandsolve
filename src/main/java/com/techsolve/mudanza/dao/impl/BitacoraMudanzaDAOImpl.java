package com.techsolve.mudanza.dao.impl;

import javax.persistence.EntityManager;

import com.techsolve.mudanza.dao.BitacoraMudanzaDAO;
import com.techsolve.mudanza.dao.util.crud.CrudDAOImpl;
import com.techsolve.mudanza.model.entities.BitacoraMudanza;

public class BitacoraMudanzaDAOImpl extends CrudDAOImpl<BitacoraMudanza, Long> implements BitacoraMudanzaDAO {
	
	public BitacoraMudanzaDAOImpl(EntityManager entityManager) {
		super(entityManager, BitacoraMudanza.class);
	}
}
