package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Funcionario;
import com.example.demo.services.FuncionarioService;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;	
	}
	
	@PostMapping("/create")
	public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario savedFuncionario = funcionarioService.saveFuncionario(funcionario);
		if(savedFuncionario != null) {
			return ResponseEntity.ok(savedFuncionario);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping
	public List<Funcionario> getAll(){
		return funcionarioService.getAllFuncionarios();
	}
	
	@GetMapping("/{id}")
	public Funcionario getById(@PathVariable Long id) {
		return funcionarioService.getFuncionarioById(id);
	}
}
