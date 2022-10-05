package com.example.cursoRest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.cursoRest.entity.MovimientoBancario;

public interface IMovimientoBancarioDao  extends CrudRepository<MovimientoBancario, Long>{
	
	public List<MovimientoBancario> findByUserId(Long id);

}
