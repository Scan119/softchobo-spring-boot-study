package com.softchobo.springboot.controller;

import com.softchobo.springboot.properties.MyProperties;
import com.softchobo.springboot.service.MyPropertyService;
import com.softchobo.springboot.service.SortService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class MainController {

//    private final Integer myPort;
    private final Environment environment;
    private final ApplicationContext applicationContext;

    private final MyProperties myProperties;
    private final SortService sortService;
    private final MyPropertyService myPropertyService;

// 생성자 롬복 대체, @Value 는 Lombok 에서는 다른 용도로 사용 되므로 지원이 안된다.
//    public MainController(SortService sortService,
//                          @Value("${my.port}") Integer myPort,
//                          Environment environment,
//                          ApplicationContext applicationContext,
//                          MyProperties myProperties) {
//        this.sortService = sortService;
//        this.myPort = myPort;
//        this.environment = environment;
//        this.applicationContext = applicationContext;
//        this.myProperties = myProperties;
//
//    }

    @GetMapping("/")
    public String sort(@RequestParam List<String> list)  {
//        System.out.println("myPort : " + myPort);
//        System.out.println("myPort(environment) : " + environment.getProperty("my.port"));
//        System.out.println("myPort(applicationContext) : " + applicationContext.getEnvironment().getProperty("my.port"));
//        System.out.println("myProperties port : " + myProperties.getPort());
//        System.out.println("myProperties height : " + myProperties.getHeight());

//        Person michel = new Person("michel", 22, Person.Grade.A );
//        System.out.println("name : " + michel.name());
//        System.out.println("학생 : " + michel);

//        Student kate = new Student("Kate", 20, Student.Grade.E);
//        System.out.println("학생 : " + kate);

//        Student jason = Student.of("Jason", 21, Student.Grade.A);
//        System.out.println("학생 : " + jason);

        return sortService.doSort(list).toString();
    }

    @GetMapping("my-height")
    public Map<String, Integer> myHeight() {
        return Map.of(
                "- my.height(@Value from service): ", myPropertyService.getMyHeight(),
                "- my.height(@ConficurationProperties): ", myProperties.getHeight()
        );
    }

//    @GetMapping("/refresh")
//    public Map<String, Set<String>> refresh() {
//        return Map.of("refreshResult", contextRefreshedEvent.r)
//    }
}
