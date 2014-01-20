package es.microforum.integrationtest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import es.microforum.model.Empresa;
import es.microforum.serviceapi.EmpresaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-data-app-context.xml"})
@TransactionConfiguration(defaultRollback=true)
public class EmpresaTest {
	
	@Autowired
	ApplicationContext contexto;
	@Autowired
	EmpresaService empresaService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaTest.class);
	
	Empresa empresa1;
	Empresa empresa2;
	List<Empresa> empresas;
	
	@Before
	public void setUp() throws Exception {
		//empresaService = contexto.getBean("springJpaEmpresaService", EmpresaService.class); no hace falta porque esta el autowired y se encarga de ello
		empresa1 = new Empresa("61123123");
		empresa2 = new Empresa("61123129");
		
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	@Transactional
	public void testFindAll() {
		empresas = empresaService.findAll();
		logger.trace("Ejecutando metodo findAll");
		assertTrue(empresas.isEmpty());
		empresaService.save(empresa1);
		empresas = empresaService.findAll();
		assertTrue(empresas.size()==1);
	}
	
	
	@Test
	@Transactional
	public void testSave() {
		empresaService.save(empresa2);
		logger.trace("Ejecutando metodo testSave");
		//assertTrue(empresaService.findByNif("61123123").equals(null));
		assertTrue(empresaService.findByNif("61123129").equals(empresa2));
	}



	
	@Test
	@Transactional
	public void testFindByNif() {
		empresaService.save(empresa1);
		logger.trace("Ejecutando metodo testFindByNif");
		assertTrue(empresaService.findByNif("61123123").equals(empresa1));
	}


	@Test
	@Transactional
	public void testDelete() {
		empresaService.save(empresa1);
		empresaService.save(empresa2);
		empresas = empresaService.findAll();
		assertTrue(empresas.size()==2);
		logger.trace("Ejecutando metodo testDelete");
		empresaService.delete(empresa2);
		empresas = empresaService.findAll();
		assertTrue(empresas.size()==1);
	
	}

}
