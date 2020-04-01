package com.techsolve.mudanza.ejb.integracion;

import org.junit.After;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.techsolve.mudanza.bo.BitacoraMudanzaBO;
import com.techsolve.mudanza.bo.exception.BoException;
import com.techsolve.mudanza.bo.impl.MudanzaBOImpl;
import com.techsolve.mudanza.bo.impl.TripsBOImpl;
import com.techsolve.mudanza.model.vo.MudanzaVO;
import com.techsolve.mudanza.util.Util;

import junit.framework.TestCase;

/**
 * Integration Test of Mudanza Business Object that manage the move
 * 
 * @author David Martinez
 *
 */
public class MudanzaBOImplTest extends TestCase {

	private static final String IDENTIFICATION = "1061759297";
	private static final String INPUT_FILE_ALL_CASES = "5\n4\n30\n30\n1\n1\n3\n20\n20\n20\n11\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n6\n9\n19\n29\n39\n49\n59\n10\n32\n56\n76\n8\n44\n60\n47\n85\n71\n91";
	private static final String INPUT_FILE_ALL_CASES_WRONG_TOTAL_DAYS = "0\n4\n30\n30\n1\n1\n3\n20\n20\n20\n11\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n6\n9\n19\n29\n39\n49\n59\n10\n32\n56\n76\n8\n44\n60\n47\n85\n71\n91";
	private static final String EXPECTED_ALL_CASES = "Case #1: 2\nCase #2: 1\nCase #3: 2\nCase #4: 3\nCase #5: 8\n";

	@Mock
	private BitacoraMudanzaBO bitacoraMudanzaBO;

	@InjectMocks
	private MudanzaBOImpl mudanzaBOImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mudanzaBOImpl = new MudanzaBOImpl(new TripsBOImpl(), bitacoraMudanzaBO);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.techsolve.mudanza.bo.impl.MudanzaBOImpl#getOutputTextFile(com.techsolve.mudanza.model.vo.MudanzaVO)}.
	 */
	public void testGetOutputTextFile() {
		final MudanzaVO mudanzaVO = new MudanzaVO();
		mudanzaVO.setIdentification(IDENTIFICATION);
		mudanzaVO.setInputFile(INPUT_FILE_ALL_CASES);
		assertEquals(mudanzaBOImpl.getOutputTextFile(mudanzaVO), EXPECTED_ALL_CASES);
	}

	/**
	 * Test method for
	 * {@link com.techsolve.mudanza.bo.impl.MudanzaBOImpl#getOutputTextFile(com.techsolve.mudanza.model.vo.MudanzaVO)}.
	 */
	public void testGetOutputTextFileWrongTotalDays() {
		final MudanzaVO mudanzaVO = new MudanzaVO();
		mudanzaVO.setIdentification(IDENTIFICATION);
		mudanzaVO.setInputFile(INPUT_FILE_ALL_CASES_WRONG_TOTAL_DAYS);
		try {
			assertEquals(mudanzaBOImpl.getOutputTextFile(mudanzaVO), EXPECTED_ALL_CASES);
		} catch (BoException e) {
			assertEquals(Util.EXCEPTION_MESSAGE_TOTAL_DAYS, e.getMessage());
		}
	}

}
