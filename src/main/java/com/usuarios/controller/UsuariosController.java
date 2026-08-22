package com.usuarios.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.modelo.Usuarios;
import com.usuarios.service.UsuarioService;



@RestController
@RequestMapping("/api/v1/usuarios")

public class UsuariosController {

	public UsuariosController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public List<Usuarios> listarAllUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
}
