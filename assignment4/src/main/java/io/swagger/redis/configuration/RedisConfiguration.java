package io.swagger.redis.configuration;

import io.swagger.redis.model.SkierVerticalWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  RedisTemplate<String, SkierVerticalWrapper> redisTemplate() {
    RedisTemplate<String, SkierVerticalWrapper> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
  }
}
