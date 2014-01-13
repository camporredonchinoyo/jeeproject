package es.microforum.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpleadoTest {

	@Test
	public void test() {
		Empleado empleado = new Empleado("71134014m");
		assertTrue(empleado.getDni().equals("71134014m"));
	}

}
