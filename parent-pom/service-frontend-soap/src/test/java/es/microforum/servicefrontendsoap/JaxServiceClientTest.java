package es.microforum.servicefrontendsoap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.microforum.servicefrontendsoap.ISalaryKillerWebService;


public class JaxServiceClientTest {
	private ISalaryKillerWebService sumadorWebService;


	@Before
	public void setUp() throws Exception {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationClientContext.xml");
			sumadorWebService = (ISalaryKillerWebService) context.getBean("jaxSumWebService");

		} catch (Throwable t) {
			t.printStackTrace();
			fail();
		}
	}

	@Test
	public void testCallFooBar() {
		try {
			int result = sumadorWebService.sumalo(1,2);
			assertTrue(result==3);
		} catch (Throwable t) {
			t.printStackTrace();
			fail();
		}
	}


}
