package com.softchobo.springboot.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

//@ConfigurationProperties("my")
//@Configuration  //이것을 생략하려면 root app 에 @ConfigurationPropertiesScan 을 지정한다.
//                //또는 configuration 파일에 method Bean 을 지정 해준다.
//public class MyProperties {
//
//    private Integer port;   //my_port, my-port, myPort 모두 가능 하나 한가지로 통일해서 사용
//
//    public Integer getPort() {
//        return port;
//    }
//
//    public void setPort(Integer port) {
//        this.port = port;
//    }
//}

//final 과 생성자를 이용한 방법
//@Configuration 을 붙이면 에러가 남 --> 생략하고 @ConfigurationPropertiesScan 지정
//@ConstructorBinding 은 deprecated
@Getter
//@RequiredArgsConstructor
@ConfigurationProperties(prefix="my")
@EnableConfigurationProperties
@RefreshScope
public class MyProperties {

    private final Integer port;   //my_port, my-port, myPort, my.height 모두 가능 하나 한가지로 통일해서 사용
    private final Integer height;

    public MyProperties(Integer port, Integer height) {
        this.port = port;
        this.height = height;
    }
}