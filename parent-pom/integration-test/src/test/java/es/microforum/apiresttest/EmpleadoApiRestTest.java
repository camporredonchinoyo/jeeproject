package es.microforum.apiresttest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import es.microforum.model.Empleado;
import es.microforum.model.Empresa;
import es.microforum.repository.EmpresaRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-data-app-context.xml" })
//@ActiveProfiles("integration_test")
public class EmpleadoApiRestTest {


	String jpaWebContext;
	
	@Autowired
	ApplicationContext context;

	@Autowired
	EmpresaRepository empresaRepository;

	private JdbcTemplate jdbcTemplate;

	@Before
	public void before() {
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		jdbcTemplate = new JdbcTemplate(dataSource);
		jpaWebContext = "http://localhost:8081/spring-data-book-rest-1.0.0.BUILD-SNAPSHOT/";
		jdbcTemplate.execute("DELETE FROM empleado");
	}

	//@Autowired
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void getTest() {
		try {
			jdbcTemplate.execute("INSERT INTO empleado values('71134014A', 'Daniel', 'Cabo Noval', 'a tope', 'empleadocol', 29000, 1, 3, null, null, 1)");
			Resource<Empleado> resource = getEmpleado(new URI("http://localhost:8081/spring-data-book-rest-1.0.0.BUILD-SNAPSHOT/empleado/71134014A"));
			assertTrue(resource.getContent().getNombre().equals("Daniel"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	private Resource<Empleado> getEmpleado(URI uri) {
		return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Resource<Empleado>>() {
		}).getBody();

	}
	
	@Test
	public void deleteTest() {
		try {
			jdbcTemplate.execute("INSERT INTO empleado values('71134014Z', 'Daniel', 'Cabo Noval', 'a tope', 'empleadocol', 29000, 1, 3, null, null, 1)");
			int count = jdbcTemplate.queryForObject("select count(*) from empleado where dni='71134014Z'", Integer.class);
			assertTrue(count == 1);
			restTemplate.delete(jpaWebContext + "empleado/71134014Z");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		int count = jdbcTemplate.queryForObject("select count(*) from empleado where dni='71134014Z'", Integer.class);
		assertTrue(count == 0);
	}
	
	@Test
	public void postTest() throws RestClientException, URISyntaxException {
		//jdbcTemplate.execute("DELETE FROM empresa where nombre like 'BORRAR!%'");
		String url = jpaWebContext + "empleado";
		String acceptHeaderValue = "application/json";

		HttpHeaders requestHeaders = new HttpHeaders();
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.valueOf(acceptHeaderValue));
		requestHeaders.setAccept(mediaTypes);
		requestHeaders.setContentType(MediaType.valueOf(acceptHeaderValue));
		HttpMethod post = HttpMethod.POST;

		//String body = "{\"codUsr\":\"test\",\"nomSubtipoSer\":\"BORRAR!\",\"fecActu\":\"2011-11-17\",\"desSubtipoSer\":\"BORRAR!\",\"tipoSerie\":{\"codTipoSerie\":\"1\"}}";
		String body = "{\"nombre\":\"Empresa1\",\"direccionFiscal\":\"Palencia 5\",\"fechaInicioActividades\":\"2014-01-01\",\"version\":\"3\",\"dni\":\"71134014R\"}";
		HttpEntity<String> entity = new HttpEntity<String>(body, requestHeaders);

		ResponseEntity<String> response = restTemplate.exchange(url, post, entity, String.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
		int count = jdbcTemplate.queryForObject("select count(*) from empresa where nif='111D'", Integer.class);
		assertTrue(count == 1);
		//jdbcTemplate.execute("DELETE FROM subtipo_serie where nom_subtipo_ser like 'BORRAR!%'");
	}
	
//
//	@Test
//	public void putTest() throws RestClientException, URISyntaxException {
//		jdbcTemplate.execute("INSERT INTO empresa values('111R', 'Empresa1', 'palencia 5', '2001-10-10 00:00:00', 1)");
//		String url = jpaWebContext + "empresa/111R";
//		String acceptHeaderValue = "application/json";
//
//		HttpHeaders requestHeaders = new HttpHeaders();
//		List<MediaType> mediaTypes = new ArrayList<MediaType>();
//		mediaTypes.add(MediaType.valueOf(acceptHeaderValue));
//		requestHeaders.setAccept(mediaTypes);
//		requestHeaders.setContentType(MediaType.valueOf(acceptHeaderValue));
//		HttpMethod put = HttpMethod.PUT;
//
//		String body = "{\"nombre\":\"Empresa2\"}";
//		HttpEntity<String> entity = new HttpEntity<String>(body, requestHeaders);
//
//		ResponseEntity<String> response = restTemplate.exchange(url, put, entity, String.class);
//		assertTrue(response.getStatusCode().equals(HttpStatus.NO_CONTENT));
//		int count = jdbcTemplate.queryForObject("select count(*) from empresa where nif='111R'", Integer.class);
//		assertTrue(count == 1);
//		//jdbcTemplate.execute("DELETE FROM subtipo_serie where nom_subtipo_ser = 'MODIFICADO!'");
//	}
//	
//	@After
//	public void after() {
//		jdbcTemplate.execute("DELETE FROM empleado");
//	}
	
	


}

