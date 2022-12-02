package com.gama.academy.radarfarma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é Obrigatório!")
	private String nome;
	
	@NotNull(message = "O atributo descrição é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo descrição deve possuir no mínimo 5 e no máximo 100 caracteres")
	private String telefone;
	
	@Schema(example = "email@email.com.br")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	@NotNull(message = "O atributo quantidade é Obrigatório!")
	private String email;
	
	@NotNull(message = "O atributo Cpf é Obrigatório!")
	private String cpf;
	
	@NotNull(message = "O atributo Cep é Obrigatório!")
	private String cep;
	
	@NotNull(message = "O atributo Logradouro é Obrigatório!")
	private String logradouro;
	
	@NotNull(message = "O atributo numero é Obrigatório!")
	private int numero;
	
	@NotNull(message = "O atributo bairro é Obrigatório!")
	private String bairro;
	
	@NotNull(message = "O atributo cidade é Obrigatório!")
	private String cidade;
	
	@NotBlank(message = "O atributo estado é Obrigatório!")
	private String estado;
	
	private String complemento;
	



	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
	


}	
