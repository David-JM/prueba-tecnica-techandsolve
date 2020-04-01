package com.techsolve.mudanza.ejb.unitaria;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.techsolve.mudanza.bo.impl.TripsBOImpl;
import com.techsolve.mudanza.util.Util;

import junit.framework.TestCase;

/**
 * Unit Test of Mudanza Business Object that manage the move
 * 
 * @author David Martinez
 *
 */
public class TripsBOImplTest extends TestCase {

	private static final String INPUT_FILE_CASE_ONE = "30\n30\n1\n1";
	private static final String INPUT_FILE_CASE_TWO = "20\n20\n20";
	private static final String INPUT_FILE_CASE_THREE = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11";
	private static final String INPUT_FILE_CASE_FOUR = "9\n19\n29\n39\n49\n59";
	private static final String INPUT_FILE_CASE_FIVE = "32\n56\n76\n8\n44\n60\n47\n85\n71\n91";
	private static final int EXPECTED_CASE_ONE = 2;
	private static final int EXPECTED_CASE_TWO = 1;
	private static final int EXPECTED_CASE_THREE = 2;
	private static final int EXPECTED_CASE_FOUR = 3;
	private static final int EXPECTED_CASE_FIVE = 8;

	@InjectMocks
	private TripsBOImpl tripsBOImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.techsolve.mudanza.bo.impl.MudanzaBOImpl#maxTrips(java.util.List)}.
	 */
	@Test
	public void testMaxTripsCaseOne() {
		assertEquals(tripsBOImpl.maxTrips(Util.split(INPUT_FILE_CASE_ONE, Util.NEW_LINE)), EXPECTED_CASE_ONE);
	}

	/**
	 * Test method for
	 * {@link com.techsolve.mudanza.bo.impl.MudanzaBOImpl#maxTrips(java.util.List)}.
	 */
	@Test
	public void testMaxTripsCaseTwo() {
		assertEquals(tripsBOImpl.maxTrips(Util.split(INPUT_FILE_CASE_TWO, Util.NEW_LINE)), EXPECTED_CASE_TWO);
	}

	/**
	 * Test method for
	 * {@link com.techsolve.mudanza.bo.impl.MudanzaBOImpl#maxTrips(java.util.List)}.
	 */
	@Test
	public void testMaxTripsCaseThree() {
		assertEquals(tripsBOImpl.maxTrips(Util.split(INPUT_FILE_CASE_THREE, Util.NEW_LINE)), EXPECTED_CASE_THREE);
	}

	/**
	 * Test method for
	 * {@link com.techsolve.mudanza.bo.impl.MudanzaBOImpl#maxTrips(java.util.List)}.
	 */
	@Test
	public void testMaxTripsCaseFour() {
		assertEquals(tripsBOImpl.maxTrips(Util.split(INPUT_FILE_CASE_FOUR, Util.NEW_LINE)), EXPECTED_CASE_FOUR);
	}

	/**
	 * Test method for
	 * {@link com.techsolve.mudanza.bo.impl.MudanzaBOImpl#maxTrips(java.util.List)}.
	 */
	@Test
	public void testMaxTripsCaseFive() {
		assertEquals(tripsBOImpl.maxTrips(Util.split(INPUT_FILE_CASE_FIVE, Util.NEW_LINE)), EXPECTED_CASE_FIVE);
	}

}
