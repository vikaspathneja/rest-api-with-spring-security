package com.example.demo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(as = User.class)
@EnableRedisRepositories
public interface UserRep extends JpaRepository<User, String>{
	Optional<User> findUserByUsername(String username); 	

}