package com.desafio.controleveiculos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.v3.oas.annotations.Operation;

import com.desafio.controleveiculos.domain.model.Usuario;
import com.desafio.controleveiculos.domain.repository.UsuarioRepository;
import com.desafio.controleveiculos.domain.service.UsuarioService;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private UsuarioService usuarioService;
		
//	@Operation(summary = "Listar todos usuários")
	@GetMapping
	public List<Usuario> listar() {		
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId) {		
		
		return usuarioRepository.findById(usuarioId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}
	

}
