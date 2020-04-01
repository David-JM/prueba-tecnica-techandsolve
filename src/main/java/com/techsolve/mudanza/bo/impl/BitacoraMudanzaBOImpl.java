package com.techsolve.mudanza.bo.impl;

import java.util.Date;

import com.techsolve.mudanza.bo.BitacoraMudanzaBO;
import com.techsolve.mudanza.bo.exception.BoException;
import com.techsolve.mudanza.dao.BitacoraMudanzaDAO;
import com.techsolve.mudanza.dao.exception.DaoException;
import com.techsolve.mudanza.model.entities.BitacoraMudanza;
import com.techsolve.mudanza.util.Util;

public class BitacoraMudanzaBOImpl implements BitacoraMudanzaBO {

	private BitacoraMudanzaDAO bitacoraMudanzaDAO;

	public BitacoraMudanzaBOImpl(BitacoraMudanzaDAO bitacoraMudanzaDAO) {
		this.bitacoraMudanzaDAO = bitacoraMudanzaDAO;
	}

	@Override
	public BitacoraMudanza create(String identification) throws BoException {
		final BitacoraMudanza bitacoraMudanza = new BitacoraMudanza();
		bitacoraMudanza.setCedula(identification);
		bitacoraMudanza.setFechaEjecucion(new Date());
		try {
			return this.bitacoraMudanzaDAO.create(bitacoraMudanza);
		} catch (DaoException e) {
			throw new BoException(Util.EXCEPTION_MESSAGE_DATA_BASE + e.getMessage());
		}
	}

}
