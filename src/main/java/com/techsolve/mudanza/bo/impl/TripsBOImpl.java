package com.techsolve.mudanza.bo.impl;

import java.util.Collections;
import java.util.List;

import com.techsolve.mudanza.bo.TripsBO;
import com.techsolve.mudanza.util.Util;

public class TripsBOImpl implements TripsBO {

	@Override
	public int maxTrips(List<Integer> linesByDay) {
		Collections.sort(linesByDay);
		int cont = Util.ZERO;
		for (int i = linesByDay.size() - Util.ONE, contPos = Util.ZERO; contPos < i; i--, cont++) {
			final int line = linesByDay.get(i);
			// Reduce the number of calculations that the algorithm must perform
			if (line >= Util.MIN_WEIGHT_BY_TRAVEL)
				continue;

			int division = Util.MIN_WEIGHT_BY_TRAVEL / line;
			if (division * line < Util.MIN_WEIGHT_BY_TRAVEL)
				division++;

			contPos += division - Util.ONE;
		}
		return cont == Util.ZERO ? Util.ONE : cont;
	}

}
