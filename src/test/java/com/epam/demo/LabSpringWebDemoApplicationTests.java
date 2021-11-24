package com.epam.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class LabSpringWebDemoApplicationTests {

	@LocalServerPort
	private int port;

	@Value("${test.inject.property}")
	private String test;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		HttpStatus statusCode = restTemplate.getForEntity("http://localhost:" + port + "/actuator/health", String.class).getStatusCode();
		assertEquals(statusCode, HttpStatus.OK);
	}

}
