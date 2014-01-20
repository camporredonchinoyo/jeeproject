package es.microforum.integrationtest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.microforum.integrationtest.HelloWorld;

public class HelloWorldTest {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldTest.class);

	@Test
	public void test() {
		logger.error("**************************!!!!!!!!!!!!!!!!!!!!!!!");
		assertTrue(HelloWorld.hello("pepe").equals("hello pepe"));
	}

}
