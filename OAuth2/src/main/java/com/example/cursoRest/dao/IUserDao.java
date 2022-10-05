package com.example.cursoRest.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.cursoRest.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);

}
