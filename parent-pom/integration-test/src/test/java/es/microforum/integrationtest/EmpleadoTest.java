package es.microforum.integrationtest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import es.microforum.model.Empleado;
import es.microforum.serviceapi.EmpleadoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-data-app-context.xml"})
@TransactionConfiguration(defaultRollback=true)
public class EmpleadoTest {
	
	@Autowired
	ApplicationContext contexto;
	@Autowired
	EmpleadoService empleadoService;
	
	Empleado empleado1;
	Empleado empleado2;
	
	@Before
	public void setUp() throws Exception {
		//empleadoService = contexto.getBean("springJpaEmpleadoService", EmpleadoService.class); no hace falta porque esta el autowired y se encarga de ello
		empleado1 = new Empleado("71134014");
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	@Transactional
	public void testFindAll() {
		List<Empleado> empleados = empleadoService.findAll();
		empleados.size();
		assertTrue(empleados.isEmpty());
	}
	
	
	@Test
	@Transactional
	public void testSave() {
		empleado2 = new Empleado("71134014", null, "nombre", "direccion", "tipoEmpleado", "empleadocol", 10000.0, 10.0, 15.0, null);
		empleadoService.save(empleado2);
		assertTrue(empleadoService.findByDni("71134014").equals(empleado2));
	}



	
	@Test
	@Transactional
	public void testFindByDni() {
		empleado2 = new Empleado("71134014", null, "nombre", "direccion", "tipoEmpleado", "empleadocol", 10000.0, 10.0, 15.0, null);
		empleadoService.save(empleado2);
		assertTrue(empleadoService.findByDni("71134014").equals(empleado2));
		
	}


	@Test
	public void testDelete() {
		empleado2 = new Empleado("71134014", null, "nombre", "direccion", "tipoEmpleado", "empleadocol", 10000.0, 10.0, 15.0, null);
		empleadoService.save(empleado2);
		empleadoService.delete(empleado2);
		List<Empleado> empleados = empleadoService.findAll();
		assertTrue(empleados.isEmpty());
	
	}

}
