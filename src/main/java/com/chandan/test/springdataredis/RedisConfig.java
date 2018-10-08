package com.chandan.test.springdataredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
   private static final String REDIS_HOST = "localhost";
   private static final Integer PORT = 6379;

   @Bean
   JedisConnectionFactory jedisConnectionFactory() {
      RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(REDIS_HOST, PORT);
      System.out.println("Creating Connection");
      return new JedisConnectionFactory(redisStandaloneConfiguration);
   }

   @Bean
   public RedisTemplate<String, Object> redisTemplate() {
      RedisTemplate<String, Object> template = new RedisTemplate<>();
      template.setConnectionFactory(jedisConnectionFactory());
      return template;
   }
}