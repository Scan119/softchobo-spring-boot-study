package com.softchobo.springboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.softchobo.springboot.domain.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.github.dockerjava.core.DefaultDockerClientConfig;
import org.testcontainers.shaded.com.github.dockerjava.core.DockerConfigFile;
import org.testcontainers.utility.DockerImageName;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
class SoftchoboSpringBootStudyApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(SoftchoboSpringBootStudyApplicationTests.class);

//	@Container
//	private static final GenericContainer<?> redisContainer =
//			new GenericContainer<>(DockerImageName.parse("redis:latest"));
//  windows 용 docker 는 config file 을 자동으로 읽지 못하는듯 --> config
	@Autowired
	private ObjectMapper mapper;

	@BeforeAll
	static void setup() {

		//redisContainer.followOutput(new Slf4jLogConsumer(logger));
	}

//	@DynamicPropertySource
//	static void properties(DynamicPropertyRegistry registry) {
//		registry.add("spring.redis.port", () -> redisContainer.getMappedPort(6379));
//	}

	@Test
	void contextLoads() throws Exception {
		//Given

        DockerConfigFile dockerConfigFile = new DockerConfigFile();
		System.out.println(dockerConfigFile.getAuthConfigurations());
		System.out.println(dockerConfigFile.toString());

		//When
//		GenericContainer.ExecResult execResult1 = redisContainer.execInContainer("redis-cli", "get", "student:cassie");
//		GenericContainer.ExecResult execResult2 = redisContainer.execInContainer("redis-cli", "get", "student:fred");
//		GenericContainer.ExecResult execResult3 = redisContainer.execInContainer("redis-cli", "get", "student:jack");
//		Student actual1 = mapper.readValue(execResult1.getStdout(), Student.class);
//		Student actual2 = mapper.readValue(execResult2.getStdout(), Student.class);
//		Student actual3 = mapper.readValue(execResult3.getStdout(), Student.class);

		//Then
//		assertThat(redisContainer.isRunning()).isTrue();
		//assertThat(actual1).isEqualTo(Student.of("cassie", 18, Student.Grade.A));
		//assertThat(actual2).isEqualTo(Student.of("fred", 14, Student.Grade.C));
		//assertThat(actual3).isEqualTo(Student.of("jack", 15, Student.Grade.B));
	}

}
