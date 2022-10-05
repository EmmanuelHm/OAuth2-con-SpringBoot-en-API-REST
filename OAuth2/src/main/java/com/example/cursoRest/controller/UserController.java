package com.example.cursoRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursoRest.entity.User;
import com.example.cursoRest.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/users")
	public ResponseEntity<?> obtenerUsuarios(){
		List<User> users = userService.findAll();
		
		if(users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create_user")
	public ResponseEntity<?> create(@RequestBody User user){
		//Se encrpita la contraseña antes de guardar usuario
		user.setPassword( bCryptPasswordEncoder.encode( user.getPassword() ) ); 
		userService.save(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
