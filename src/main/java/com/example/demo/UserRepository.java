package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(as = User.class)
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Modifying
	@Query("update User u set u.username=?1 where u.id=?2")
	void setUsername(String name,long id);
	

}