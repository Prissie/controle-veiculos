package com.desafio.controleveiculos.domain.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.desafio.controleveiculos.domain.model.Usuario;

public class UsuarioDto {
	
	@NotBlank(message = "{nome.notblank}")
	private String nome;
	
	@NotBlank(message = "{email.notblank}")
	@Email(message = "{email.notvalid}")
	private String email;
	
	@NotBlank(message = "{cpf.notblank}")
	@CPF(message = "{cpf.notvalid}")
	private String cpf;
	
	@NotNull(message = "{dataNascimento.notempty}")
	private LocalDate dataNascimento;

	public Usuario toUser() {
		Usuario usuario = new Usuario();
		usuario.setNome(this.getNome());
		usuario.setEmail(this.getEmail());
		usuario.setCpf(this.getCpf());
		usuario.setDataNascimento(this.getDataNascimento());
		return usuario;
	}

	private String getEmail() {
		return email;
	}

	private String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}	
	
}
