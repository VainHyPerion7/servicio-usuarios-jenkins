package com.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.modelo.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{

}
