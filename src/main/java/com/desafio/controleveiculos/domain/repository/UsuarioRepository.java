package com.desafio.controleveiculos.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.controleveiculos.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByNome(String nome);
	List<Usuario> findByNomeContaining(String nome);
	Optional<Usuario> findByEmail(String email);

}
