package com.desafio.controleveiculos.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Email
	@Size(max = 25)
	@Column(unique = true)
	private String email;

	@NotBlank
	@Size(max = 11)
	@Column(unique = true)
	private String cpf;

	@Column(nullable = false)
	private LocalDate dataNascimento;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	public void addVeiculo(Veiculo veiculo) {
		veiculo.setUsuario(this);
		veiculos.add(veiculo);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		//LocalDate date = LocalDate.parse(dataNascimento);
		this.dataNascimento = dataNascimento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + "]";
	}

}
