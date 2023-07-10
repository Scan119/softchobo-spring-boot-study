package com.softchobo.springboot.config;

import com.softchobo.springboot.properties.MyProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.username("asdf");
        builder.password("asdfgh");
        builder.url("jdbc:h2:mem:test");
        builder.driverClassName("org.h2.Driver");

        return builder.build();
    }

//    @ConfigurationProperties("my")
//    @Bean
//    public MyProperties myProperties() {
//        return new MyProperties();
//    }
}

