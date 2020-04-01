package com.techsolve.mudanza.bo;

import java.util.List;

/**
 * Business Object to manage the trips of a move
 * 
 * @author David Martinez
 *
 */
public interface TripsBO {

	/**
	 * Method to calculate the maximum numbers of trips in a day
	 * 
	 * @param linesByDay
	 *            list of items (weight) of a day
	 * @return the number of max trips
	 */
	public int maxTrips(List<Integer> linesByDay);

}
