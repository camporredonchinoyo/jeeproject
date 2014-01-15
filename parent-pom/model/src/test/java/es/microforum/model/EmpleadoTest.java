package es.microforum.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmpleadoTest {
	
	Empleado empleado1;
	Empleado empleado2;

	@Before
	public void setUp() throws Exception {
		empleado1= new Empleado("71134014m");
	}
//
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		empleado2 = new Empleado("71134014m");
		assertTrue(empleado1.equals(empleado2));
	}

}
