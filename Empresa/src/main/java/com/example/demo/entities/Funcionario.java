package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "Mínimo de 3 caracteres")
	private String nomeFuncionario;
	
	@NotNull
	@Size(min = 6, message = "Mínimo de 6 caracteres")
	private String dataNascimento;
	
	@NotNull
	private float salario;
	
	@ManyToOne
	//JoinColumn vai criar uma tabela fornecedor_id no Funcionario para Relacionar
	@JoinColumn(name="departamento_id")
	private Departamento departamento;
	
	//Getters e Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setNome(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
