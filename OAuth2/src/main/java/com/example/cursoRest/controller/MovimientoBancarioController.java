package com.example.cursoRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursoRest.entity.MovimientoBancario;
import com.example.cursoRest.entity.User;
import com.example.cursoRest.service.IMovimientoBancarioService;

@RestController
@RequestMapping("/api/oauth2")
public class MovimientoBancarioController {
	
	@Autowired
	private IMovimientoBancarioService movimientoBancarioService;
	
	@GetMapping("/movimiento_bancario")
	public ResponseEntity<?> movimientos(){
		List<MovimientoBancario> movimientosBancarios = movimientoBancarioService.findAll();
		
		if(movimientosBancarios != null ) {
			return new ResponseEntity<>(movimientosBancarios, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/movimiento_bancario_user")
	public ResponseEntity<?> movimientoUser(@RequestBody User user){
		List<MovimientoBancario> movimientosBancarios = movimientoBancarioService.getMovimientoUser(user.getId());
		
		if(movimientosBancarios != null ) {
			return new ResponseEntity<>(movimientosBancarios, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
