package es.microforum.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTest {

	@Test
	public void test() {
		Empresa empresa = new Empresa("B12344567");
		assertTrue(empresa.getNif().equals("B12344567"));
	}

}
