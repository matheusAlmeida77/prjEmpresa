package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Departamento;
import com.example.demo.entities.Funcionario;
import com.example.demo.repositories.DepartamentoRepository;
import com.example.demo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;
	private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository, DepartamentoRepository departamentoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.departamentoRepository = departamentoRepository;
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		if(funcionario.getDepartamento() != null && funcionario.getDepartamento().getId() != null) {
			Optional<Departamento> departamento = departamentoRepository.findById(funcionario.getDepartamento().getId());
			if(departamento.isPresent()) {
				funcionario.setDepartamento(departamento.get());
				return funcionarioRepository.save(funcionario);
			}else {
				throw new RuntimeException("Departamento não encontrado");
			}
		}else {
			throw new RuntimeException("O ID do Departamento é obrigatório");
		}
	}
	
	public Funcionario getFuncionarioById(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionarios(){
		return funcionarioRepository.findAll();
	}
}