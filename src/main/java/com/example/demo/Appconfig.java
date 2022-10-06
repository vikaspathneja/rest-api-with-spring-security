package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Appconfig {

	   @Bean 
	   public PasswordEncoder passwordEncoder() { 
	      return new BCryptPasswordEncoder(); 
	   } 
	   @Bean 
	   public PasswordEncoder passwordEncoder2() { 
	      return new BCryptPasswordEncoder(); 
	   }
	   
	   
//	   @Bean
//	   public JedisConnectionFactory redisConnectionFactory() {
//		   JedisConnectionFactory factory=new JedisConnectionFactory();
//		   factory.setHostName("20.172.134.86");
//		factory.setPort(6379);
//		return factory;
//		   }
	   
	   @Bean
	   public LettuceConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("20.172.134.86", 6379));
		   
	   }
	   
	   
	   
	   @Bean
	   public RedisTemplate<String, Object> redisTemplate(){
		   RedisTemplate<String, Object> rt=new RedisTemplate<String, Object>();
		   rt.setConnectionFactory(redisConnectionFactory());
		   rt.setKeySerializer(new StringRedisSerializer());
		   rt.setHashKeySerializer(new StringRedisSerializer());
		   rt.setHashKeySerializer(new JdkSerializationRedisSerializer());
		   rt.setHashValueSerializer(new JdkSerializationRedisSerializer());	
		   rt.setEnableTransactionSupport(true);
		   rt.afterPropertiesSet();
		   return rt;
		   
	   }
}
