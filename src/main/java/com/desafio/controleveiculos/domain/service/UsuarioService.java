package com.desafio.controleveiculos.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.controleveiculos.domain.exception.NegocioException;
import com.desafio.controleveiculos.domain.model.Usuario;
import com.desafio.controleveiculos.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {
		boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail())
				.stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe usuário cadastrado com este e-mail.");
		}
		
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void excluir(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}
}
