package com.example;

import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@SpringBootTest
@SpringJUnitConfig
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Ignore
public class SampleApplicationTests {

//    @ClassRule
//    public static DockerComposeContainer environment =
//            new DockerComposeContainer(new File("compose-test.yml"))
//                    .withExposedService("rabbitmq", 5672)
//                    .withExposedService("mysql", 3306)
//					.waitingFor("mysql", Wait.forLogMessage(".*ready for connections.*", 1).withStartupTimeout(Duration.ofMinutes(1)));

//	@Container
//	private static final RabbitMQContainer rabbitMQContainer = new RabbitMQContainer();
//
//	@Container
//	private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>();
//
////	@DynamicPropertySource
////	static void dynamicProperties(DynamicPropertyRegistry registry) {
////		// Set Spring Boot properties to point to the RabbitMQ and MySQL containers
////		registry.add("spring.rabbitmq.host", rabbitMQContainer::getHost);
////		registry.add("spring.rabbitmq.port", rabbitMQContainer::getAmqpPort);
////		registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
////		registry.add("spring.datasource.username", mySQLContainer::getUsername);
////		registry.add("spring.datasource.password", mySQLContainer::getPassword);
////	}
//
//	@BeforeAll
//	public void setUp() {
//		// Start the RabbitMQ and MySQL containers
//		rabbitMQContainer.start();
//		mySQLContainer.start();
//	}
//
//	@AfterAll
//	public void tearDown() {
//		// Stop and remove the containers
//		rabbitMQContainer.stop();
//		mySQLContainer.stop();
//	}
//
//	@Test
//	public void contextLoads() {
//		// Ensure that the application context loads without errors
////		assertNotNull(rabbitMQContainer);
////		assertNotNull(mySQLContainer);
//	}
}
