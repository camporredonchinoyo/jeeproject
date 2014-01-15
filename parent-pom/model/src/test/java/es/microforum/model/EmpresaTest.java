package es.microforum.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {
	
	Empresa empresa1;
	Empresa empresa2;
	
	@Before
	public void setUp() throws Exception {
		 empresa1 = new Empresa("B12344567");
	}
//
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		empresa2  = new Empresa("B12344567");
		assertTrue(empresa1.equals(empresa2));
	}

}
