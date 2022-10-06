package com.example.demo.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails usr=(UserDetails)repo.findUserByUsername(username).get();
		return usr;
	}


	@Autowired
	EntityManager em;
	
	@Autowired
	SessionFactory sf;
	
	
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
