package com.techsolve.mudanza.bo.impl;

import java.util.List;

import com.techsolve.mudanza.bo.BitacoraMudanzaBO;
import com.techsolve.mudanza.bo.MudanzaBO;
import com.techsolve.mudanza.bo.TripsBO;
import com.techsolve.mudanza.bo.exception.BoException;
import com.techsolve.mudanza.model.vo.MudanzaVO;
import com.techsolve.mudanza.util.Util;

public class MudanzaBOImpl implements MudanzaBO {

	private TripsBO tripsBO;
	private BitacoraMudanzaBO bitacoraMudanzaBO;

	public MudanzaBOImpl(TripsBO tripsBO, BitacoraMudanzaBO bitacoraMudanzaBO) {
		this.tripsBO = tripsBO;
		this.bitacoraMudanzaBO = bitacoraMudanzaBO;
	}

	@Override
	public String getOutputTextFile(MudanzaVO mudanzaVO) throws BoException {
		final List<Integer> lines = Util.split(mudanzaVO.getInputFile(), Util.NEW_LINE);
		final int totalDays = lines.get(Util.ZERO);

		if (totalDays >= Util.ONE && totalDays <= Util.FIVE_HUNDRED) {
			int idxInit = Util.ZERO, idxEnd = Util.ONE;
			final StringBuilder outputFile = new StringBuilder();

			for (int day = Util.ONE; day <= totalDays; day++) {
				// Index of First W Item (per day)
				idxInit = idxEnd + Util.ONE;
				// Index of last W Item (per day)
				idxEnd = idxInit + lines.get(idxEnd);
				final List<Integer> linesByDay = lines.subList(idxInit, idxEnd);
				outputFile.append(Util.CASE).append(day).append(Util.TWO_DOT);
				outputFile.append(tripsBO.maxTrips(linesByDay)).append(Util.NEW_LINE);
			}
			bitacoraMudanzaBO.create(mudanzaVO.getIdentification());
			return outputFile.toString();
		} else
			throw new BoException(Util.EXCEPTION_MESSAGE_TOTAL_DAYS);
	}

}