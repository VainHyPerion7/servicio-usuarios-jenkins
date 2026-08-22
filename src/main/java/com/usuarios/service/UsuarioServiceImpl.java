package com.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usuarios.modelo.Usuarios;
import com.usuarios.repository.UsuarioRepository;




@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private  UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuarios> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	
	

}
