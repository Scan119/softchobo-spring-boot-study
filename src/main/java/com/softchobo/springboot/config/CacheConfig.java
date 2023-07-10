package com.softchobo.springboot.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .computePrefixWith(name -> name + ":")
                .entryTtl(Duration.ofSeconds(10))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    // redis cache 를 사용할때 Serialization 을 Jackson 으로 설정 한다.
    // 이때 java 의 implements Serializable 도 삭제를 해야 한다.
    // 또한 Jackson 을 사용하려면 도메인 객체에 기본 생성자가 있어야 한다.

}
