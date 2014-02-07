package es.microforum.apiresttest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



//ApplicationContext will be loaded from
@ContextConfiguration(locations = { "classpath:spring-data-app-context.xml" })
//@ActiveProfiles("integration_test")
public class EmpresaApiRestTest {


	String jpaWebContext;
	@Autowired
	ApplicationContext context;

	@Autowired
	EmpresaRepository empresaRepository;

	private JdbcTemplate jdbcTemplate;

	@Before
	public void before() {
		//DataSource dataSource = (DataSource) context.getBean("dataSource");
		//jdbcTemplate = new JdbcTemplate(dataSource);
		//jdbcTemplate.execute("DELETE FROM empresa");
	}

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void getTest() {
		try {
			Resource<Empresa> resource = getEmpresa(new URI("http://localhost:8081/spring-data-book-rest-1.0.0.BUILD-SNAPSHOT/empresa/111A"));
			assertTrue(resource.getContent().getNombre().equals("Empresa1"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	private Resource<Empresa> getEmpresa(URI uri) {
		return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Resource<Empresa>>() {
		}).getBody();

	}


}