package com.techsolve.mudanza.bo;

import com.techsolve.mudanza.bo.exception.BoException;
import com.techsolve.mudanza.model.entities.BitacoraMudanza;

/**
 * Business Object to manage the traceability of moves made
 * 
 * @author David Martinez
 *
 */
public interface BitacoraMudanzaBO {

	/**
	 * Method to create a trace of the execution
	 * 
	 * @param identification
	 *            (executor's id)
	 * @return the trace created
	 * @throws BoException
	 */
	public BitacoraMudanza create(String identification) throws BoException;

}
