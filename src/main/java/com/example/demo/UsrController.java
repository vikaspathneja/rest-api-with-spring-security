package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UsrController {
	
//	@Autowired
//	private UserService userservice;

	@PostMapping(path = "/gotologin")
	public String validateUser(HttpServletRequest request) {
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		return null;
	}


}
