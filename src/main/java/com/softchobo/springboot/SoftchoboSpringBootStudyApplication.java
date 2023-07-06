package com.softchobo.springboot;

import com.softchobo.springboot.properties.MyProperties;
import com.softchobo.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication(
		scanBasePackages = {"com.softchobo.springboot"}
)
@ConfigurationPropertiesScan
//@RequiredArgsConstructor
//Cach 적용
@EnableCaching // 캐시적용할 db 매서드에 @Cacheable("cache 이름") 적용
@EnableConfigServer
public class SoftchoboSpringBootStudyApplication {

//	@Value("${My.port}")
//	private static Integer myPort;  // 이렇게 초기화 하면 초기화 싯점 문제로 null이 됨

//	private final Integer myPort;	//생성자 주입으로 초기화시 문제 없음
	private final Environment environment;
	private final ApplicationContext applicationContext;
//	public SoftchoboSpringBootStudyApplication(
//			@Value("${my.port}") Integer myPort,
//			Environment environment,
//			ApplicationContext applicationContext) {
//			this.myPort = myPort;
//			this.environment = environment;
//			this.applicationContext = applicationContext;
//	}

	private final MyProperties myProperties;
	private final StudentService studentService;
	private final String username;
	private final String password;

	public SoftchoboSpringBootStudyApplication(
			Environment environment,
			ApplicationContext applicationContext,
			MyProperties myProperties,
			StudentService studentService,
			@Value("${spring.datasource.username}") String username,
			@Value("${spring.datasource.password}") String password
	) {
		this.environment = environment;
		this.applicationContext = applicationContext;
		this.myProperties = myProperties;
		this.studentService = studentService;
		this.username = username;
		this.password = password;
	}

	public static void main(String[] args) {

		SpringApplication.run(SoftchoboSpringBootStudyApplication.class, args);

//		SpringApplication app = new SpringApplication(SoftchoboSpringBootStudyApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);

//		new SpringApplicationBuilder(SoftchoboSpringBootStudyApplication.class)
//				.bannerMode(Banner.Mode.OFF)
//				.run(args);

	}

//	@PostConstruct
//	public void printPort() {
//		//System.out.println("@Value " + myPort);
//		System.out.println("@Envronment " + environment.getProperty("my.port"));
//		System.out.println("@ApplicationContext " + applicationContext.getEnvironment().getProperty("my.port"));
//
//	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		// studentService.printStudent("jack");
		// studentService.printStudent("jack");
		// studentService.printStudent("jack");
		System.out.println("id : " + username);
		System.out.println("pd : " + password);
	}

}
