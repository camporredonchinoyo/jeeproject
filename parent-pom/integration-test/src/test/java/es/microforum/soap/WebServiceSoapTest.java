package es.microforum.soap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.microforum.model.Empleado;
import es.microforum.serviceapi.EmpleadoService;
import es.microforum.servicefrontendsoap.ISalaryKillerWebService;

public class WebServiceSoapTest {
	
	private ISalaryKillerWebService variaSueldosWebService;
	private EmpleadoService empleadoService;
	private Empleado empleado2;

	@Before
	public void setUp() throws Exception {
		try{
			// Creación de contexto y bean jax
			ApplicationContext ctxSpring = new ClassPathXmlApplicationContext("spring-data-app-context.xml");
			variaSueldosWebService = (ISalaryKillerWebService) ctxSpring.getBean("jaxVariadorSueldoWebService");
			// Creacion del bean de servicio
			empleadoService = ctxSpring.getBean("springJpaEmpleadoService", EmpleadoService.class);
			empleado2 = new Empleado("71134014", null, "nombre", "direccion", "tipoEmpleado", "empleadocol", 10000.0, 10.0, 15.0, null);
		} catch(Throwable t){
			t.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSalaryKillerWebService() {
			double porcentaje = 10.0;
			empleadoService.save(empleado2);
			Empleado empleado = empleadoService.findByDni("71134014");
			double sueldoNoModificado = empleado.getSalarioAnual();
			empleadoService.variarSueldoEmpleado(porcentaje);
			empleado = empleadoService.findByDni("71134014"); 
			assertTrue(sueldoNoModificado != empleado.getSalarioAnual());
			assertTrue(((sueldoNoModificado * porcentaje) / 100) + sueldoNoModificado == empleado.getSalarioAnual());
	}

}
