package com.usuarios.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.usuarios.modelo.Usuarios;
import com.usuarios.service.UsuarioService;

@WebMvcTest(UsuariosController.class)
public class UsuariosControllerPruebaUnitariaJunitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private UsuarioService usuarioService;
	
	@Test
	@DisplayName ("Debe listar todos los Usuarios")
	void listarPersonas() throws Exception{
		Usuarios usuarios = new Usuarios(1,"admin","pass","ROLE_ADMIN");
		
		when(usuarioService.listarUsuarios()).thenReturn(List.of(usuarios));
		
		mockMvc.perform(get("/api/v1/usuarios/listar"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id").value(1))
		.andExpect(jsonPath("$[0].username").value("admin"))
		.andExpect(jsonPath("$[0].password").value("pass"))
		.andExpect(jsonPath("$[0].role").value("ROLE_ADMIN"));
				
	}

}
