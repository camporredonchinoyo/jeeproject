package es.microforum.integrationtest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import es.microforum.model.Empleado;
import es.microforum.model.Empresa;
import es.microforum.serviceapi.EmpleadoService;
import es.microforum.serviceapi.EmpresaService;

public class EmpresaTest {
	EmpresaService empresaService;

	@Before
	public void setUp() throws Exception {
		GenericXmlApplicationContext contexto = new GenericXmlApplicationContext();
		contexto.load("classpath:spring-data-app-context.xml");
		contexto.refresh();

		empresaService = contexto.getBean("springJpaEmpresaService", EmpresaService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testFindAll() {
		List<Empresa> empresas = empresaService.findAll();
		assertTrue(empresas.isEmpty());
	}

//	@Test
//	public void testFindByDni() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSave() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}

}
