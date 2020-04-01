package com.techsolve.mudanza.ejb.integracion;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.techsolve.mudanza.bo.impl.BitacoraMudanzaBOImpl;
import com.techsolve.mudanza.dao.BitacoraMudanzaDAO;
import com.techsolve.mudanza.model.entities.BitacoraMudanza;

import junit.framework.TestCase;

/**
 * Test of Bitacora Business Object that manage the traceability of moves made
 * 
 * @author David Martinez
 *
 */
public class BitacoraMudanzaBOImplTest extends TestCase {

	private static final String IDENTIFICATION = "1061759297";

	@Mock
	private BitacoraMudanzaDAO bitacoraMudanzaDAO;

	@InjectMocks
	private BitacoraMudanzaBOImpl bitacoraMudanzaBOImpl;

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
	 * {@link com.techsolve.mudanza.bo.impl.BitacoraMudanzaBOImpl#create(java.lang.String)}.
	 */
	@Test
	public void testCreate() {
		when(bitacoraMudanzaDAO.create(any(BitacoraMudanza.class))).thenReturn(new BitacoraMudanza());
		assertNotNull(bitacoraMudanzaBOImpl.create(IDENTIFICATION));
	}

}
