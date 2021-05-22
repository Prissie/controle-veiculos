package com.desafio.controleveiculos.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.controleveiculos.domain.model.Usuario;

@RestController
public class UsuarioController {
	
	@GetMapping("/usuarios")
	public List<Usuario> listar() {
		Usuario usuario1 = new Usuario();
		usuario1.setNome("João de Deus");
		usuario1.setCpf("32202020021");
		usuario1.setEmail("joao@email.com");
		
		return Arrays.asList(usuario1);
	}
}
