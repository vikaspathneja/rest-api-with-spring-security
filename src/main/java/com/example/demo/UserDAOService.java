package com.example.demo;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class UserDAOService {
		
	@Autowired
	EntityManager em;
	
	@Autowired
	SessionFactory sf;
	
	@Autowired
	private UserRepository repo;
	
	public User insert(User user){
		return repo.save(user);
	}
	
	public void update(User user){
		repo.setUsername(user.getUsername(), user.getId());
	}
	
	public void delete(long userid){
		repo.deleteById(userid);
	}
	
	public User getUser(long userid) {
		Optional<User> uu=repo.findById(userid);
		return uu.isPresent()==true?uu.get():null;
	}
	
	
}