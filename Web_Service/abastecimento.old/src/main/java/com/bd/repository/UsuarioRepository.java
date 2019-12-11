package com.bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
