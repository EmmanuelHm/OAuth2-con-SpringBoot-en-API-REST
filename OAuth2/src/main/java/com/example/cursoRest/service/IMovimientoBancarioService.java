package com.example.cursoRest.service;

import java.util.List;

import com.example.cursoRest.entity.MovimientoBancario;

public interface IMovimientoBancarioService {

	public List<MovimientoBancario> findAll();
	
	public void save(MovimientoBancario movimientoBancario);
	
	public List<MovimientoBancario> getMovimientoUser(Long id);
}
