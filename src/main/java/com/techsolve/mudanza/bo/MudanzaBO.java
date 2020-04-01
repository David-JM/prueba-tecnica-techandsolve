package com.techsolve.mudanza.bo;

import com.techsolve.mudanza.bo.exception.BoException;
import com.techsolve.mudanza.model.vo.MudanzaVO;

/**
 * Business Object to manage the move
 * 
 * @author David Martinez
 *
 */
public interface MudanzaBO {

	/**
	 * Method to generate a output text that contains the number of travels for
	 * each day, according to the data in input file
	 * 
	 * @param mudanzaVO
	 *            with executor's id and input file
	 * @return the output text
	 * @throws BoException
	 */
	public String getOutputTextFile(MudanzaVO mudanzaVO) throws BoException;

}
