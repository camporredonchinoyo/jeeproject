package es.microforum.serviceimpl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.microforum.model.Empleado;

public class EmpleadoTest {
	
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		EmpleadoServiceImpl empleadoServiceImpl = null;
		List<Empleado> empleados = empleadoServiceImpl.findAll();
		
		//assertTrue(empleadoServiceImpl.findAll().equals(o));
		//assertTrue(empleadoServiceImpl.findByDni(dni));
		
	}

}
