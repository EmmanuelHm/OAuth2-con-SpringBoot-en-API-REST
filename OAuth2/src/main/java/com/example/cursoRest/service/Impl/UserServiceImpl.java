package com.example.cursoRest.service.Impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cursoRest.dao.IUserDao;
import com.example.cursoRest.entity.User;
import com.example.cursoRest.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		
		if(user  == null) {
			throw new UsernameNotFoundException("Usuario no valido");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE ADMIN")));
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userDao.findById(id).orElse(null);
	}

}
